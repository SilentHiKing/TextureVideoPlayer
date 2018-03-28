# TextureVideoPlayer
使用TextureView显示Player数据

https://www.jianshu.com/p/420f7b14d6f6

https://github.com/xiaoyanger0825/NiceVieoPlayer

# 对原工程的解析
## nicevideoplayer架构
此library重要的两个类

NiceVideoPlayer：显示和解析视屏的容器FrameLayout mContainer，其本身也是FrameLayout

有两个View构成，Z轴上下显示：

* TextureView：负责视频MedioPlayer的播放显示
* NiceVideoPlayerController 继承自FrameLayout，对触摸事件的反馈及MedioPlayer的响应

## 改进
对MedioPlayer的解耦合，目前是在NiceVideoPlayer中直接生成其对象

想法：

定义VideoPlayer播放操作的系列接口，三方的Player生成其对象，来实现其接口

问题：

Player一般都会有Listener,需要传本身或子类进去，无法完全解耦，待解决

## 类图
![class_image](https://github.com/SilentHiKing/TextureVideoPlayer/blob/master/doc/VideoPlayer%E7%B1%BB%E5%9B%BE.png)

![order_image](https://github.com/SilentHiKing/TextureVideoPlayer/blob/master/doc/VideoPlayer%E6%97%B6%E5%BA%8F%E5%9B%BE.png)
