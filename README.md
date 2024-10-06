# Project Primis: Quaker!

## Table of Contents

1. [Introduction](#introduction)  
2. [Project Highlights](#highlights)  
3. [Current Features](#current-features)  
4. [Future Features](#future-features)  
5. [About Us](#about-us)  
6. [Contacts](#contacts)

## Introduction

This project is a groundbreaking solution for the challenge titled "**Seismic Detection Across the Solar System**", part of an application called **Quaker!**. Our mission was to build a machine learning model capable of detecting seismic activity on the Moon, Mars, and potentially any planetary body across the solar system. By leveraging data from historical lunar and Martian missions—primarily the Apollo mission—we aim to predict seismic events in environments vastly different from Earth.

#### How It Works:

At the heart of this project is a sophisticated approach that marries signal processing with deep learning, transforming raw seismic waveforms into meaningful insights about planetary seismic activity.  
- **Wavelet Transform for Feature Extraction**:  
The seismic data is intricate, often noisy, and unique to each planetary surface. We used wavelet transforms to extract critical features from the seismic waveforms. This technique captures the intricate frequency patterns of seismic events, helping us identify the telltale signs of activity. By decomposing the signals into multiple levels, we get a clearer, more detailed picture of seismic waves as they traverse extraterrestrial terrains.

- **Deep Learning Architecture**:  
To bring this data to life, we've developed a deep learning model—a sequential neural network architecture that combines Dense layers, Dropout layers (to prevent overfitting), and Batch Normalization layers (to ensure stability during training). The model is designed to predict the precise arrival times of seismic waves, unlocking insights about the internal structures of planets like the Moon and Mars.

- **Performance Metrics**:  
Every model needs a solid foundation in evaluation, and ours is no exception. We rely on standard metrics like mean squared error (MSE), mean absolute error (MAE), and R-squared (R²) to rigorously assess how well our model performs. These metrics help us fine-tune the model, ensuring that its predictions are as accurate as possible in these extraterrestrial environments.

- **Real-World Testing**:  
After training on the data, the model is tested on seismic records from various lunar stations and Martian data to predict seismic event times. These predictions are compiled into catalogs, providing a detailed timeline of seismic activity that can be used for further planetary research and mission planning.

_Why This Matters_:  
This project is more than just a technical exercise—it's a key to unlocking the mysteries of other worlds. Seismic activity is like the heartbeat of a planet, and understanding it provides clues about the planet’s internal structure, geological processes, and even its history. By detecting and predicting seismic events on planetary bodies, we can help scientists map out the unseen interiors of these distant worlds. Moreover, this has practical implications for future space exploration. Quaker could become an essential tool for monitoring planetary seismic activity, serving as an early warning system for future missions to Mars or the Moon, where astronauts and infrastructure could be vulnerable to seismic disturbances.

This is a full application that allows users to upload seismic data and detects whether the data contains seismic events, such as quakes. The system was created for the NASA Space Apps Challenge and is aimed at scientists and researchers who need a reliable tool to analyze seismic data for planetary seismic activities. The project uses a Java Spring Boot backend to handle file uploads from a Flutter-based frontend. The uploaded files are processed using a Python script that analyzes the data for signs of seismic events.

## Project Highlights

- **NASA Space Apps Challenge Project**:  
  This project was built as part of the "Seismic Detection Across the Solar System" challenge.

- **Target Audience**:  
  Designed for scientists and researchers involved in seismology and geological studies, particularly those who need to determine if seismic data contains signs of seismic events.

- **Automated Seismic Event Detection**:  
  The Python script processes seismic data files and provides a simple output indicating the presence or absence of seismic events.

- **Cross-Platform Support**:  
  Quaker can be accessed via a mobile or web app, making it versatile for users across different platforms.

## Current Features

- Upload seismic data files via a Flutter frontend interface.
- Temporarily store uploaded files in `resources/temp_files`.
- Unzip (if necessary) and save data files in `resources/extractedFiles`.
- Use a Python script to analyze seismic data and detect seismic events.
- Provide results indicating whether the data contains seismic activity (like quakes).
- Allow users to download a CSV file containing the results of the analysis.

## Future Features

- **Enhanced Visualization**:  
  Include graphical visualizations of detected seismic events, providing a clearer picture for users.

- **Real-Time Analysis**:  
  Enable real-time processing of seismic data for quicker results and faster decision-making.

- **Expanded Data Sources**:  
  Incorporate additional data sources from upcoming space missions to expand Quaker’s capabilities across other planetary bodies.

- **User Account and Data Management**:  
  Provide a user management system for scientists to track and store their uploaded files and analysis results over time.

- **API Integration**:  
  Develop an API that allows integration with other tools and datasets used by seismologists and researchers.

## About Us

Team **Primis** is a diverse group of friends thrilled to be part of the NASA Space Apps Challenge. We are passionate about technology, innovation, and space exploration. Though our backgrounds vary, we share a common goal: to solve complex challenges using cutting-edge technology and creativity. Inspired by the Cod Zombies franchise's "Primis" crew, we believe in pushing boundaries and exploring the unknown to unlock the mysteries of our universe.

## Contacts

For any inquiries, please contact our team members directly:

- **Munis Mamwn Alawneh**  
  - Email: munis.alawneh.sep2018@gmail.com  

- **Laith Allabadi**  
  - Email: laithellabadi04@gmail.com  

- **Mohannad Rababah**  
  - Email: dodorapapah@gmail.com  

- **Alameen Mahmoud Mohammed Sabbah**  
  - Email: 55910337.a@gmail.com  

- **Asem Omar Hatamleh**  
  - Email: asemhatamleh999@gmail.com  

- **Hashem Kamel Hashem Elshaweesh**  
  - Email: alshaweeshhashem414@gmail.com  
