#coding=utf-8
import urllib2, re, urllib

def getHtml(url):
    html = urllib2.urlopen(url).read()
    return html

def getImageList(html, url):
    # 去掉url末尾影响相对路径转绝对路径的障碍
    lastdivider = url.rindex('/')
    suffix = url[lastdivider+1:]
    if (suffix.find('.')>0):
        url = url[0:lastdivider]
    # pat = re.compile(r'<img.+src="(.+?)"')
    pat = re.compile(r'src="(.*?\.jpg)"')
    imgList = re.findall(pat, html)
    # 如果图片地址是相对路径，则改为绝对路径以便之后下载
    for i in range(len(imgList)):
        if ('http' not in imgList[i]):
            imgList[i] = url + '/' + imgList[i]
    return imgList

# 根据图片地址提取图片名（此方法还可以写的更优雅一点）
def getImgName(imgUrl):
    lastDivider = imgUrl.rindex('/')
    imgName = imgUrl[lastDivider+1:]
    return imgName

def downloadImg(imgList):
    for i in range(len(imgList)):
        imgName = getImgName(imgList[i])
        urllib.urlretrieve(imgList[i], "images/%s" % imgName)
        print 'done -> ' + imgName

# 从 url.config 文件中逐行取得网址
def getFileContent(fileName):
    urlList = []
    for line in open(fileName).readlines():
        line = line.strip('\n')
        if (line.startswith('#')):
            continue
        if (line == ''):
            continue
        urlList.append(line)
    return urlList

if __name__ == '__main__':
    urlList = getFileContent('url.config')
    for url in urlList:
        html = getHtml(url)
        print html
        imgList = getImageList(html, url)
        print 'will download url -> ' + url
        print imgList
        downloadImg(imgList)












# 此方法暂未使用
def getHerfs(html):
    pat = re.compile('href=\"(.+?)\"')
    linkList = re.findall(pat, html)
    return linkList

# 此方法暂时未使用  根据后缀返回图片类型，目前只支持三种(不通用)
def getImgType(imgUrl):
    if (imgUrl.endswith('png')):
        return 'png'
    if (imgUrl.endswith('jpg')):
        return 'jpg'
    if (imgUrl.endswith('jpeg')):
        return 'jpeg'