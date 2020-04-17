# Readme
# Ranking System

[![N|Solid](https://cdn.newsapi.com.au/image/v1/6c38669f223f7e1cd7ca952aa0f7ba8d?width=700)]

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Our Ranking System is a normal-distribution based model to predict the rest games of this season in EPL.

  - Draw a ranking board of the end of season
  - Predict the win rate of each two teams' match
  - We've also considered the effect of hometeam and awayteam.

# Features

  - Calculate the win probability that team A will beat team B if they meet each other head to head match-up, and divide into home and away circumstance.
  -  Predict the remaining game of 19-20 season based on last five year data.
  -  Export a ranking table by their final score.


You can also:
  - Output the predicted tables as .csv file
  - Distinguish between home and away games
  - See the previous game results in system



> We use English Premier League 2015-2020 result in our project.
> (In each row, we have home team, away team, home team goals, away team goals and wins or losses,please check it in our data file match.csv)

Bingo

### Tech and Concept

Dillinger uses a number of open source projects to work properly:

* [Normal distribution] - Core concept for our system
* [Commons Math] - The important package we use to do the math work
* [.csv] - The result's format we chosse
* [EPL] - English premier league and where we foung the data


And of course Dillinger itself is open source with a public repository 
on GitHub.

### Usage


Install the dependencies and devDependencies and start the server.

For ranking system...
```sh
$ package System
$ public class RankingSystem{
```

For team data prediction...

```sh
$ package System
$ public class Team{
```



### Development


Core package:
```sh
$ import org.apache.commons.math3.distribution.NormalDistribution;
```

imports:
```sh
$ import java.io.BufferedReader;
$ import java.io.File;
$ import java.io.FileNotFoundException;
$ import java.io.FileReader;
$ import java.io.IOException;
```




#### Kubernetes + Google Cloud

See [KUBERNETES.md](https://github.com/joemccann/dillinger/blob/master/KUBERNETES.md)


### Todos in future

 - Predict more leagues other than EPL
 - Use less data to predict MORE

License
----

MIT


**Thank you! Have a nice day and stay safe!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)



   [df1]: <http://daringfireball.net/projects/markdown/>
   [.csv]: <https://en.wikipedia.org/wiki/Comma-separated_values>
   [Commons Math]: <http://commons.apache.org/proper/commons-math/index.html>
   [EPL]: <https://www.premierleague.com/>
   [Normal distribution]: <https://en.wikipedia.org/wiki/Normal_distribution>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
