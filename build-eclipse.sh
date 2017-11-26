#!/bin/bash

BASE=$(dirname $0)

function build(){
	BUILD_DIR=$(dirname $1)
	pushd $BUILD_DIR
	gradle eclipse
	gradle build
	popd
}

for file in $(find $BASE -name build.gradle) ;
do
	build $file
done
