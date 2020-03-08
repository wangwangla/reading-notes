#!/bin/bash

git add .

read -t 30 -p "write note:" msg

echo "[commit message] $msg, submit: $(whoami), submit time: ${time}"
git commit -m "$msg, submit: $(whoami), submit time: ${time}"

	
git push origin master
echo " GitAutoPush Ending..."