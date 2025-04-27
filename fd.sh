#!/bin/bash
pid=`ps -ef | grep 'test_fd.py' | grep -v 'grep' | awk '{print $2}'`
echo 'pid: '$pid
ls /proc/$pid/fd
ls /proc/$pid/fd | wc -l
lsof -p $pid | more