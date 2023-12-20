
const express = require("express");
const app = express();
const bcrypt = require('bcrypt');
const saltRounds = 10;
const tf = require('@tensorflow/tfjs');
const admin = require("firebase-admin");
const credentials = require("./serviceAccountKey.json");
const path = require('path');
const multer = require('multer');
const {Storage} = require('@google-cloud/storage');


const storage = new Storage({
  projectId: 'secucare-406900',
  keyFilename: './serviceAccountKey.json'
});

const bucket = storage.bucket('secucare');

const upload = multer({
  storage: multer.memoryStorage(),
  limits: {
    fileSize: 25 * 1024 * 1024, // limit file size to 25MB
  },
});




 

admin.initializeApp({
    credential: admin.credential.cert(credentials)
});

app.use(express.json());

app.use(express.urlencoded({extended: true}));

const db = admin.firestore();

app.post('/create', async (req, res) => {
    try {
        console.log(req.body);
        const id = req.body.email;
        const userJson = {
            email: req.body.email,
            name: req.body.name,
            password: req.body.password,
            lokasi: new admin.firestore.GeoPoint(req.body.latitude, req.body.longitude),
            phoneNum: req.body.phoneNum,
            distance: 0
        }; 
    const response = await db.collection("users").add(userJson);
    res.send(response);
  } catch(error) {
    res.send(error);
  }
});

app.get('/', (req, res) => {
  res.send('Hello, World!');
});

app.get('/read/all', async (req, res) => {
    try {
        const userRef = db.collection("users");
        const response = await userRef.get();
        let responseArr = [];
        response.forEach(doc => {
            responseArr.push(doc.data());
        });
        res.send(responseArr);
    }   catch(error) {
        res.send(error);
    }
});

app.get('/read/:id', async (req, res) => {
    try {
        const userRef = db.collection("users").doc(req.params.id);
        const response = await userRef.get();
        res.send(response.data());
    }   catch(error) {
        res.send(error);
    }
});

app.post('/update', async (req, res) => {
    try {
        const userRef = db.collection("users").doc(req.body.id);
        await userRef.update(req.body);
        const updatedDoc = await userRef.get();
        res.send(updatedDoc.data());
    } catch(error) {
        res.send(error);
    }
});

app.delete('/delete/:id', async (req, res) => {
    try {
        const response = await db.collection("users").doc(req.params.id).delete();
        res.send(response);
    }   catch(error) {
        res.send(error);
    }
});

// Signup route
app.post('/signup', async (req, res) => {
    try {
        const hashedPassword = await bcrypt.hash(req.body.password, saltRounds);
        const userJson = {
            email: req.body.email,
            name: req.body.name,
            password: hashedPassword,
            // add other fields as necessary
        };
        const response = await db.collection("users").add(userJson);
        res.send(response.id);
    } catch(error) {
        res.send(error);
    }
});

// Login route
app.post('/login', async (req, res) => {
    try {
        const userSnapshot = await db.collection("users").where('email', '==', req.body.email).get();
        if (userSnapshot.empty) {
            res.status(400).send('Invalid email or password');
            return;
        }
        const userData = userSnapshot.docs[0].data();
        const passwordMatch = await bcrypt.compare(req.body.password, userData.password);
        if (!passwordMatch) {
            res.status(400).send('Invalid email or password');
            return;
        }
        res.send('Logged in successfully');
    } catch(error) {
        res.send(error);
    }
});

// upload foto
app.post('/upload', upload.single('photo'), (req, res) => {
    if (!req.file) {
      res.status(400).send('No file uploaded.');
      return;
    }
  
    const blob = bucket.file(req.file.originalname);
    const blobStream = blob.createWriteStream();
  
    blobStream.on('error', err => {
      console.error(err);
      res.status(500).send(err);
    });
  
    blobStream.on('finish', () => {
      const publicUrl = `https://storage.googleapis.com/${bucket.name}/${blob.name}`;
      res.status(200).send(publicUrl);
    });
  
    blobStream.end(req.file.buffer);
  });

 

app.get('/getNearest', async (req, res) => {
    try {
      const latitude = req.query.latitude;
      const longitude = req.query.longitude;
  
      // Query for all users
      const userRef = db.collection("users");
      const users = await userRef.get();
  
      // Initialize results array
      const results = [];
  
      // Iterate over all users
      users.forEach((doc) => {
        // Calculate distance between user and center point
        const distance = admin.firestore.GeoPoint.distance(doc.data().lokasi, new admin.firestore.GeoPoint(latitude, longitude));
  
        // Add user to results if distance is less than 2km
        if (distance <= 2000) {
          results.push(doc.data());
        }
      });
  
      // Send results to client
      res.send(results);
    } catch (error) {
      res.send(error);
    }
  });


const PORT = process.env.PORT || 8080;  
app.listen(PORT, () => {console.log('server is running on PORT ${PORT}.');
});
