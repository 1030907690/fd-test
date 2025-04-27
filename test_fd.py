import os
import time
import sys
from concurrent.futures import ThreadPoolExecutor


def open_file(i: int = 0):
    name_prefix = "test.txt"
    file_name = name_prefix + str(i)
    if os.path.exists(file_name) is False:
        f = open(file_name, 'w')
        f.write("b")
        f.close()

    print("打开  ", file_name)
    f = open(file_name, encoding="utf-8")
    # f.close()

    time.sleep(999)


if __name__ == '__main__':
    pool = ThreadPoolExecutor(2000)
    num = sys.argv[1]
    for i in range(0, int(num)):
        print("i ", str(i))
        pool.submit(open_file, i)
        # f = open(name_prefix +str(i),encoding="utf-8")

    time.sleep(999)
