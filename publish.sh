#!/bin/bash
git pull
java -jar letgodbetrue-1.0-SNAPSHOT-jar-with-dependencies.jar
git add LetGodBeTrue.rss
git add size-cache.csv
git commit -m "update"
git push
date +"%Y%m%d %H:%M:%S" >> run.log
