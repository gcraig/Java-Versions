#!/usr/bin/python

# unix/linux systems
# dd if=/dev/urandom of=source.dat bs=1024 count=102400

import os

with open('source.dat', 'wb') as fout:
    fout.write(os.urandom(102400000))

