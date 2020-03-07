#!/bin/bash
echo $(curl -sL http://www.letgodbetrue.com/sermons/index.php$(date +%s) | md5sum | cut -d ' ' -f 1)
online_md5=$(curl -sL -H 'Cache-Control: no-cache' http://www.letgodbetrue.com/sermons/index.php$(date +%s) | md5sum | cut -d ' ' -f 1)
local_md5="$(cat state)"
if [ "$online_md5" == "$local_md5" ]; then
    echo "hurray, they are equal!"
fi
echo 'new content'
echo 'old content'
echo "$local_md5"
echo $online_md5
echo "$online_md5" > state
echo 'new content has been processed'