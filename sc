#!/bin/bash

print_usage () {
  printf "Usage: Script file manager\n
  The sc script is a script file manager that takes one or two arguments to run a script from within this folder.
  Scripts are called using\n \tsc <folder> [script]\n\n The script can be named the same as the containing folder and then can be called with just\n \tsc <folder>\n\n
  Flags:\n
  c\t Create - useage sc -c <folder> [script]\n
  e\t Edit - usage sc -e <folder> [script]\n
  d\t delete - usage sc -d <folder> [script]\n"
}


if [ $# == 0 ]; then
  print_usage
  exit 0
fi

while getopts 'ced' flag; do
  case "${flag}" in
    c) ~/scripts/script/create ${@:2} 
      exit 0
      ;;
    e)
      ~/scripts/script/edit ${@:2} 
      exit 0
      ;;
    d)
      ~/scripts/script/delete ${@:2} 
      exit 0
      ;;
  esac
done

case $# in
  1)
    ~/scripts/$1/$1
    ;;
  2) 
    ~/scripts/$1/$2
    ;;
  *)
    ~/scripts/$1/$2 ${@:3}
    ;;
esac

