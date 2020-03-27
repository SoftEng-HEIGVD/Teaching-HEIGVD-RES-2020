# Teaching-HEIGVD-RES-2020 (THIS IS THE PLANNING FOR RES-C STUDENTS)
This is the main repo for the course RES, taught at HEIG-VD in 2020. 

This is where you will find lecture notes, slides and some of the examples presented in the class. We will also keep links to the different repos used throughout the semester (for assignments).

## Upcoming deadlines

* <u>**Thursday**</u>, April 2nd: everybody must have **studied the material about TCP programming in Java** (and prepared questions for things that are not clear, so that we can review them during the live session). Everybody must have **executed and studied the code of the example projects**. In particular, the structure of the multi-threaded server must be well understood.
- <u>**Thursday**</u>, April 2nd: **ideally**, some people will have started the exercise of specifying the "calculator protocol", possibly even the implementation in Java. If this is the case, the students could present their solution so that we can discuss it together (and so that other people can learn from them).
- **Thursday**, April 9th: date of the **first test**, covering Java IOs, TCP programming and Docker introduction.


## General links

- YouTube [playlist](https://www.youtube.com/playlist?list=PLfKkysTy70Qa1IYbV9Xndojc7L-T4keF-)

## ~~Week 1: introduction~~

* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Chill) is the repo for the first assignment. Make sur to **fork** it, before cloning your fork on your machine.
* [Here](https://www.youtube.com/playlist?list=PLfKkysTy70QaN-uez0K4UpSpVUbt8ETpk) is  the Youtube playlist that presents the first assignment material.

## ~~Week 2~~

* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/blob/master/slides/01-JavaIOs.pdf) are the slides
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/blob/master/lectures/01-Lecture1-JavaIOs.md) are the lecture notes
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/tree/master/examples/01-BufferedIOBenchmark/BufferedIOBenchmark) is the project used to present the impact of buffering on performance
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Labo-Java-IO) is the repo for the lab, which we will work on during weeks 2 and 3

## ~~Week 3~~

* We are still using the same deck as last week
* Same thing for the lecture notes
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/tree/master/examples/02-FileIOExample/FileIOExample) is the project used to demonstrate File IOs
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/tree/master/examples/03-CharacterIODemo/CharacterIODemo) is the project used to demonstrate character encoding

## ~~Week 4~~

* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/blob/master/slides/02-TcpProgramming.pdf) are the slides
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/tree/master/examples/05-DumbHttpClient/DumbHttpClient) is an example of a simple TCP client (which does NOT implement the HTTP spec)
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/tree/master/examples/04-StreamingTimeServer/StreamingTimeServer) is an example of a simple TCP server (streams current time)
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/tree/master/examples/07-TcpServers/TcpServers) is an example of a multi-threaded TCP server (with workers)
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/tree/master/examples/06-PresenceApplication/PresenceApplication) is an example of a client-server application (presence)
* **Make sure that you have a working Wireshark on your machine!**
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Exercise-Protocol-Design) is the repo for the protocol design exercise

## ~~Week 5~~

* ~~Review of protocol design exercise, with **student presentations & demonstrations**~~
* ~~Intro to Docker & UDP~~
* **COVID-19 RESPONSE PLAN**
* Important: please take the time to **study** all the lecture notes until TCP programming. **Make sure that you know how to implement a client and a server (also a multi-threaded one)**. If you are stuck, or if there is something that you do not understand in the code examples, SHOOT OUT.
* **There is still a test coming up in 2 weeks!!**

## Week 6

* Study TCP material (slides and lecture notes)
* Study the code examples
* Start the "calculator" protocol design exercise. See [this repo](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Exercise-Protocol-Design).

## Week 7

* **Review the protocol specification. We will look at your proposals, identify issues and walk you through our specification.** As mentioned during the last lecture, be ready to write a protocol spec in an upcoming evaluation (test and/or exam).
* **Focus on Docker introduction**. Here our goal is to understand what Docker is and why it is a useful technology that we must all master. 
* We will **use videos to share knowledge and lab procedures** do get familiar with the basics (installation, creation of images with `docker build` and launching of containers with `docker run`).
* This **introduction is critical for the follow-up weeks**.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 8: Written test (April 9th)

* **We maintain the evaluation as scheduled**. We still need to figure out the logistics, but everyone must be available on Teams on April 3rd, at 10:25 sharp. If for some reason you are unavailable at this time, please reach out to me BEFORE the time.
* **It will cover everything until TCP programming and the Docker introduction.**
* During the evaluation, you will very likely have to create and run Docker containers, based on the short procedures presented before.

## Week 8': (Easter Break)

* Read the 2 chapters on [HTTP protocol](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/blob/master/lectures/04-Lecture4-HTTP.md) and [Web Infrastructures](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020/blob/master/lectures/05-Lecture5-WebInfrastructure.md), to get ready for the lab.
* During the break, please read these chapters to be ready to start the big "web infra" lab the following week.

## Week 9

* **We start to present the HTTP protocol**, so that you can get started with the HTTP infrastructure (long) lab. We are preparing videos to present this material.
* In this lab, we will use Docker to create a complete web infrastructure with a reverse proxy and several HTTP servers.
* **We start working on the HTTP infrastructure lab**. We already have a series of 12 webcasts (~6 hours) that guide you through the process, so we are in good shape.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 10

* We continue with our presentation of HTTP in videos for the theoretical part.
* We continue with the HTTP infrastructure lab.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 11

* We complete the HTTP infrastructure lab.
* We complete the HTTP infrastructure lab.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 12: Written test (May 14th)

* **We maintain the date for the evaluation, which will focus on HTTP.** 
* Both on the protocol aspects (presented in the new videos) and on the infrastructure aspects (presented in new videos and put in practice in the lab)

## Week 13: ~~(Ascencion, courtesy of COVID-19)~~

* We introduce UDP programming, with videos.
* We start with the "Orchestra" lab.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 14:

* We continue with UDP programming, with videos.
* We complete the "Orchestra" lab.
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 15:

* We introduce the SMTP protocol.
* We start the SMTP lab (we already have webcasts that walk you through the procedures)
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

## Week 16:

* We complete the theoretical part of the SMTP protocol.
* We complete the SMTP lab
* **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**



## [at this point, calendar is still subject to change...]



## Past deadlines

~~<u>**Sunday**</u>, March 8th: everybody must have (individually):~~

- ~~completed the [Java IO lab](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Labo-Java-IO)~~
