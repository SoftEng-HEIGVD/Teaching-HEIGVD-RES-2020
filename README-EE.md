# Teaching-HEIGVD-RES-2020 (THIS IS THE PLANNING FOR RES-C STUDENTS)
This is the main repo for the course RES, taught at HEIG-VD in 2020. 

This is where you will find lecture notes, slides and some of the examples presented in the class. We will also keep links to the different repos used throughout the semester (for assignments).

## Upcoming deadlines

* ~~Monday, June 1st: deadline to submit the **HTTP infrastructure** lab~~
* ~~Thursday, May 28th: deadline to submit the **HTTP infrastructure** lab~~
* Thursday, June 18th: **second written test**
* Sunday, June 28th: deadline to submit the **Orchestra lab** (UDP)


## General links

- YouTube [playlist](https://www.youtube.com/playlist?list=PLfKkysTy70Qa1IYbV9Xndojc7L-T4keF-)

## ~~Week 1: introduction~~

* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Chill) is the repo for the first assignment. Make sur to **fork** it, before cloning your fork on your machine.
* [Here](https://www.youtube.com/playlist?list=PLfKkysTy70QaN-uez0K4UpSpVUbt8ETpk) is  the Youtube playlist that presents the first assignment material.

## ~~Week 2~~

* [Here](slides/01-JavaIOs.pdf) are the slides
* [Here](lectures/01-Lecture1-JavaIOs.md) are the lecture notes
* [Here](examples/01-BufferedIOBenchmark/BufferedIOBenchmark) is the project used to present the impact of buffering on performance
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Labo-Java-IO) is the repo for the lab, which we will work on during weeks 2 and 3

## ~~Week 3~~

* We are still using the same deck as last week
* Same thing for the lecture notes
* [Here](examples/02-FileIOExample/FileIOExample) is the project used to demonstrate File IOs
* [Here](examples/03-CharacterIODemo/CharacterIODemo) is the project used to demonstrate character encoding

## ~~Week 4~~

* [Here](slides/02-TcpProgramming.pdf) are the slides
* [Here](examples/05-DumbHttpClient/DumbHttpClient) is an example of a simple TCP client (which does NOT implement the HTTP spec)
* [Here](examples/04-StreamingTimeServer/StreamingTimeServer) is an example of a simple TCP server (streams current time)
* [Here](examples/07-TcpServers/TcpServers) is an example of a multi-threaded TCP server (with workers)
* [Here](examples/06-PresenceApplication/PresenceApplication) is an example of a client-server application (presence)
* **Make sure that you have a working Wireshark on your machine!**
* [Here](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Exercise-Protocol-Design) is the repo for the protocol design exercise

## ~~Week 5~~

* ~~Review of protocol design exercise, with **student presentations & demonstrations**~~
* ~~Intro to Docker & UDP~~
* **COVID-19 RESPONSE PLAN**
* Important: please take the time to **study** all the lecture notes until TCP programming. **Make sure that you know how to implement a client and a server (also a multi-threaded one)**. If you are stuck, or if there is something that you do not understand in the code examples, SHOOT OUT.
* **There is still a test coming up in 2 weeks!!**

## ~~Week 6~~

* Study TCP material (slides and lecture notes)
* Study the code examples
* Start the "calculator" protocol design exercise. See [this repo](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Exercise-Protocol-Design).

## Week 7

* ~~**Review the protocol specification. We will look at your proposals, identify issues and walk you through our specification.** As mentioned during the last lecture, be ready to write a protocol spec in an upcoming evaluation (test and/or exam).~~
* Watch and [study the video](https://www.youtube.com/watch?v=95GwsyiSMXI&list=PLfKkysTy70QaSEH6AqwIzVqHJKId73sqR&index=2&t=1s) describing the solution to the **CALC protocol**.
* **Focus on Docker introduction**. Here our goal is to understand what Docker is and why it is a useful technology that we must all master. 
* We will **use [videos](https://www.youtube.com/playlist?list=PLfKkysTy70QbseGZcVbpTXhas2xrXKk61) to share knowledge and lab procedures** do get familiar with the basics (installation, creation of images with `docker build` and launching of containers with `docker run`).
* This **introduction is critical for the follow-up weeks**.

## Week 8: Written test (April 9th)

* ~~**We maintain the evaluation as scheduled**. We still need to figure out the logistics, but everyone must be available on Teams on April 3rd, at 10:25 sharp. If for some reason you are unavailable at this time, please reach out to me BEFORE the time.~~
* ~~**It will cover everything until TCP programming and the Docker introduction.**~~
* ~~During the evaluation, you will very likely have to create and run Docker containers, based on the short procedures presented before.~~

## Week 8': (Easter Break)

* **Catch up on TCP programming, protocol design and Docker. Get ready for test.**
* Read the 2 chapters on [HTTP protocol](lectures/04-Lecture4-HTTP.md) and [Web Infrastructures](lectures/05-Lecture5-WebInfrastructure.md), to get ready for the lab.
* During the break, please read these chapters to be ready to start the big "web infra" lab the following week.

## Week 9

* **THE FIRST WRITTEN TEST IS RESCHEDULED HERE.**
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
  
* ## Week 10

  * We continue with our presentation of HTTP in videos for the theoretical part.
  * **We start working on the HTTP infrastructure lab**. We already have a series of 12 webcasts (~6 hours) that guide you through the process, so we are in good shape.
  * In this lab, we will use Docker to create a complete web infrastructure with a reverse proxy and several HTTP servers.
  * All the instructions for the HTTP infrastructure lab are available in [this repo](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Labo-HTTPInfra), with links to the YouTube webcasts.

  ## Week 11

  * We continue with the HTTP infrastructure lab.
  * **The teaching team will reach out to you during the normal RES lecture and lab sessions to see how you are progressing and help you.**

  ## Week 12

  * We continue with the HTTP infrastructure lab.
  * ~~We maintain the date for the evaluation, which will focus on HTTP.**~~ 
  * ~~Both on the protocol aspects (presented in the new videos) and on the infrastructure aspects (presented in new videos and put in practice in the lab)~~

  ## Week 13: ~~(Ascencion, courtesy of COVID-19)~~

  * We continue the HTTP infrastructure lab.

  ## Week 14

  * We **complete** the HTTP infrastructure lab.
  
  



## Past deadlines

~~<u>**Sunday**</u>, March 8th: everybody must have (individually):~~

- ~~completed the [Java IO lab](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2020-Labo-Java-IO)~~

* <u>**Thursday**</u>, April 2nd: everybody must have **studied the material about TCP programming in Java** (and prepared questions for things that are not clear, so that we can review them during the live session). Everybody must have **executed and studied the code of the example projects**. In particular, the structure of the multi-threaded server must be well understood.

- <u>**Thursday**</u>, April 2nd: **ideally**, some people will have started the exercise of specifying the "calculator protocol", possibly even the implementation in Java. If this is the case, the students could present their solution so that we can discuss it together (and so that other people can learn from them).
- ~~**Thursday**, April 9th: date of the **first test**, covering Java IOs, TCP programming and Docker introduction.~~
- **REVISED SCHEDULED !!!! Thursday**, April 23rd: date of the **first test**, covering Java IOs, TCP programming and Docker introduction.

