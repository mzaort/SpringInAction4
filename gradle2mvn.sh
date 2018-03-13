#!/bin/bash

BASE=$(dirname $0)
TASK=pomify
SNIPPT=$( readlink -f ${BASE}/gradle.snippt)

function translate(){
	BUILD_DIR=$(dirname $1)
	pushd $BUILD_DIR
	if [ ! -e pom.xml ]
	then
		grep ${TASK} build.gradle > /dev/null
		if [ $? -ne 0 ]
		then
			sed -i "$ r ${SNIPPT}" build.gradle
		fi
		gradle pomify
	fi
	popd
}

for file in $(find $BASE -name build.gradle) ;
do
	translate $file
done
