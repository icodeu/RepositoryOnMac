#coding=utf-8
# import sys
# reload(sys)
# sys.setdefaultencoding('utf-8')
from bs4 import BeautifulSoup
import MySQLdb

def saveToDB(classroominfo):
    # 获取 classroominfo 列表中的信息
    building = classroominfo[0]
    room = classroominfo[1]
    one = classroominfo[2]
    two = classroominfo[3]
    three = classroominfo[4]
    four = classroominfo[5]
    five = classroominfo[6]
    six = classroominfo[7]
    seven = classroominfo[8]

    db = MySQLdb.connect("localhost", "root", "", "classroom", use_unicode=True, charset="utf8")
    cursor = db.cursor()

    sql = "insert into classroominfo(building, room, one, two, three, four, five, six, seven) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')" \
                                                                                                    % (building, room, one, two, three, four, five, six, seven)

    try:
        cursor.execute(sql)
        db.commit()
    except:
        db.rollback()

    db.close()


def start():
    html = open('list.html').read()
    soup = BeautifulSoup(html)

    all_tr = soup.find_all('tr')

    # 先把前两个没用的 tr pop 出去
    all_tr.pop(0)
    all_tr.pop(0)

    for tr in all_tr:
        all_td = tr.findAll('td')

        classroominfo = []   # 0-楼  1-教室号  2-第一节  3-第二节 4-中午  5-第三节  6-第四节  7-第五节  8-第六节
        for td in all_td:
            classroominfo.append(td.text)
        # Save classroominfo to Database
        saveToDB(classroominfo)

if __name__ == '__main__':
    start()
