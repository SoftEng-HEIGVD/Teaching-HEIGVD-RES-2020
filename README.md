# Teaching-HEIGVD-RES-2020
This is the main repo for the course RES, taught at HEIG-VD in 2020. 

This is where you will find lecture notes, slides and some of the examples presented in the class. We will also keep links to the different repos used throughout the semester (for assignments).

## Upcoming deadlines (tentative schedule)

* Thursday, May 28th: deadline to submit the **HTTP infrastructure** lab
* Sunday, June 7th, deadline to submit the **Orchestra lab** (UDP)
* Friday, June 12th: **second written test**

## General links

- YouTube [playlist](https://www.youtube.com/playlist?list=PLfKkysTy70Qa1IYbV9Xndojc7L-T4keF-)

## Week 1: introduction

* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Chill) is the repo for the first assignment. Make sur to **fork** it, before cloning your fork on your machine.
* [Here](https://www.youtube.com/playlist?list=PLfKkysTy70QaN-uez0K4UpSpVUbt8ETpk) is  the Youtube playlist that presents the first assignment material.

## Week 2

* [Here](slides/01-JavaIOs.pdf) are the slides
* [Here](lectures/01-Lecture1-JavaIOs.md) are the lecture notes
* [Here](examples/01-BufferedIOBenchmark/BufferedIOBenchmark) is the project used to present the impact of buffering on performance
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Labo-Java-IO) is the repo for the lab, which we will work on during weeks 2 and 3

## Week 3

* We are still using the same deck as last week
* Same thing for the lecture notes
* [Here](examples/02-FileIOExample/FileIOExample) is the project used to demonstrate File IOs
* [Here](examples/03-CharacterIODemo/CharacterIODemo) is the project used to demonstrate character encoding

## Week 4

* [Here](slides/02-TcpProgramming.pdf) are the slides
* [Here](examples/05-DumbHttpClient/DumbHttpClient) is an example of a simple TCP client (which does NOT implement the HTTP spec)
* [Here](examples/04-StreamingTimeServer/StreamingTimeServer) is an example of a simple TCP server (streams current time)
* [Here](examples/07-TcpServers/TcpServers) is an example of a multi-threaded TCP server (with workers)
* [Here](examples/06-PresenceApplication/PresenceApplication) is an example of a client-server application (presence)
* **Make sure that you have a working Wireshark on your machine!**
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Exercise-Protocol-Design) is the repo for the protocol design exercise

## Week 5

* ~~Review of protocol design exercise, with **student presentations & demonstrations**~~
* ~~Intro to Docker & UDP~~
* **COVID-19 RESPONSE PLAN**
* Important: please take the time to **study** all the lecture notes until TCP programming. **Make sure that you know how to implement a client and a server (also a multi-threaded one)**. If you are stuck, or if there is something that you do not understand in the code examples, SHOOT OUT.
* **There is still a test coming up in 2 weeks!!**

## Week 6

* **Review the protocol specification. We will look at your proposals, identify issues and walk you through our specification.** As mentioned during the last lecture, be ready to write a protocol spec in an upcoming evaluation (test and/or exam).
* **Focus on Docker introduction**. Here our goal is to understand what Docker is and why it is a useful technology that we must all master. 
* We will **use videos to share knowledge and lab procedures** do get familiar with the basics (installation, creation of images with `docker build` and launching of containers with `docker run`).
  * The videos are available on the [RES 2020 YouTube playlist](https://www.youtube.com/playlist?list=PLfKkysTy70QaSEH6AqwIzVqHJKId73sqR):
    * Docker (introduction)
    * Docker (architecture and installation)
    * Docker (images and containers)
* This **introduction is critical for the follow-up weeks**.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 7: Written test (April 3rd)

* **We maintain the evaluation as scheduled**. We still need to figure out the logistics, but everyone must be available on Teams on April 3rd, at 10:25 sharp. If for some reason you are unavailable at this time, please reach out to me BEFORE the time.
* **It will cover everything until TCP programming and the Docker introduction.**
* During the evaluation, you will very likely have to create and run Docker containers, based on the short procedures presented before.
* During the lab session, watch the additional Docker video: Docker (top 10 commands).

## Week 8: (Easter Friday)

* Read the 2 chapters on [HTTP protocol](lectures/04-Lecture4-HTTP.md) and [Web Infrastructures](lectures/05-Lecture5-WebInfrastructure.md), to get ready for the lab.
* Because of the Easter "break", you have 2 weeks to do that. Please do it. Please.

## Week 9

* **We start to present the HTTP protocol**, so that you can get started with the HTTP infrastructure (long) lab. We are preparing videos to present this material.
* This week, the goal is to get familiar with the basics of the HTTP protocol. After watching a series of videos and studying the lecture notes, you should be able to describe the syntax of HTTP messages (requests and responses). You should also be able to describe what are the most important status codes that HTTP servers send back to the client.
* In the videos, we show demonstrations of various tools (including servers running in Docker containers). You have to redo these experiments on your machine (but you don't have any report or deliverable to submit - it is prep work for the upcoming lab and tests).
* For the videos, watch these 4 videos in the "Le Protocole HTTP" [playlist](https://www.youtube.com/playlist?list=PLfKkysTy70QZG5eUH6nyLrUZLn8Hnlf86):
  * introduction
  * outils
  * observation
  * codes de status
* For the lecture notes, study this chapter:
  * [Lecture 4 - HTTP](lectures/04-Lecture4-HTTP.md)
* For the slides, look at:
  * [Lecture 4 - HTTP](slides/04-HTTPProtocol.pdf)
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 10

* We continue with our presentation of HTTP in videos for the theoretical part.
* **We start working on the HTTP infrastructure lab**. We already have a series of 12 webcasts (~6 hours) that guide you through the process, so we are in good shape.
* In this lab, we will use Docker to create a complete web infrastructure with a reverse proxy and several HTTP servers.
* All the instructions for the HTTP infrastructure lab are available in [this repo](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Labo-HTTPInfra), with links to the YouTube webcasts.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**



## Week 11

* We continue with the HTTP infrastructure lab.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 12

* We continue with the HTTP infrastructure lab.
* ~~We maintain the date for the evaluation, which will focus on HTTP.**~~ 
* ~~Both on the protocol aspects (presented in the new videos) and on the infrastructure aspects (presented in new videos and put in practice in the lab)~~

## Week 13: ~~(Ascencion, courtesy of COVID-19)~~

* We **complete** the HTTP infrastructure lab.

## Week 14

* We introduce UDP programming, with videos.
* We start the "Orchestra" lab.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 15

* We present the SMTP protocol.
* We complete the "Orchestra" lab.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 16

* Second written test.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**



## [at this point, calendar is still subject to change...]



## Past deadlines

* ~~<u>**Sunday**</u>, March 8th: everybody must have (individually):~~
- ~~completed the [Java IO lab](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Labo-Java-IO)~~
  
* ~~<u>**Friday**</u>, March 20th: everybody must be ready to do a demo of the Calculator client-server.~~
  - ~~Your code must be available in a GitHub repo~~

- ~~<u>**Friday**</u>, March 20th: **execute** the code (with the debugger and Wireshark) and **study** the code of the 3 examples.~~
- ~~<u>**Friday**</u>, April 3rd: **everybody must be online at 10:20 sharp**, ready to do the first test for the semester. The scope for the test is defined as follows:~~
  * ~~You must have studied all the material (lecture notes, slides and code examples) for the chapters on **Java IO** and **TCP programming**.~~
  * ~~You must have watched the following **videos about Docker** on the [RES 2020 YouTube playlist](https://www.youtube.com/playlist?list=PLfKkysTy70QaSEH6AqwIzVqHJKId73sqR):~~
    * ~~Docker (introduction)~~
    * ~~Docker (architecture and installation)~~
    * ~~Docker (images and containers)~~
    * ~~Note: **Docker (top 10 des commandes pour démarrer) has been recorded afterwards**. It is useful to watch it as well (the first part, relatively short, lists the commands, the second part is a demo). The video is particularly useful to understand the difference between `docker run` and `docker exec`, two commands that are useful for analyzing containers.~~
  * ~~While watching the Docker videos, you must have installed Docker and made your own experiments with the [GitHub repository](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Exercise-Protocol-Design) that shows how to package a TCP server implemented in Java into a Docker image. You must be able to start a container running the server. You must be able to start another container in interactive mode and to connect to the server with `netcat`.~~
  * ~~Last but **<u>not least</u>**. You must be really sharp on the process to design and specify an application level protocol. You must have watched very carefully [this video](https://www.youtube.com/watch?v=95GwsyiSMXI) on the YouTube playlist. You must be able to apply this process for a new protocol.~~
- ~~**The test will be organized as follows:**~~
  * ~~At **10:15**, everybody joins the channel "**Travail écrit 1 (AB)**" on Teams, so that **at 10:20 everybody is ready to go**.~~
  * ~~At **10:20**, I will share an invitation to an **"assignment" in a GitHub classroom**. You will get access to a private GitHub repository, where you will have the guidelines for **2 exercises**. You will provide your solution in files, that **you must not forget to commit** when you are done! The system automatically creates a pull request and a feedback branch, where you will get my feedback after the grading.~~
  * ~~**IMPORTANT**: The deadline to turn in the assignment will be set to **11:45** in the system. This means that **any commit you do AFTER the deadline will be ignored by the system**. So, as soon as you start to work on your solution, commit and push what you have done so far.~~
  * ~~At **11:50**, I will release a quiz on the "Travail écrit (AB) channel". You will have 10 minutes to answer 10 questions.~~







