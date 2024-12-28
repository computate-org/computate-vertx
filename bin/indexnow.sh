#!/bin/bash

cd $HOME/.local/src/computate-vertx
env WATCH=false \
  GENERATE_NOW=true \
  VARS_PATH=$HOME/.local/src/computate-vertx/vars.yaml \
  COMPUTATE_SRC=$HOME/.local/src/computate \
  COMPUTATE_VERTX_SRC=$HOME/.local/src/computate-vertx \
  SITE_LANG=enUS \
  $HOME/.local/src/computate/bin/enUS/index.sh
