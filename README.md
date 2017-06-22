写在前面:

1.此工具类为整理工具类,可能会有重复,大家可一起维护整理,添加和删除一些常用的工具类,并写上注释.

2.希望大家积极整理维护,争取创建一个强大的android工具类.

3.本项目已上传到[jitpack.io](https://jitpack.io),使依赖更方便.

4.依赖jar包下载:
- 由于CSDN不能修改上传的资源,此jar包仅为1.0版本
- [CSDN下载](http://download.csdn.net/detail/qq_31590149/9840984)
- 最新依赖jar包下载,请点击跳转
- [百度云下载](http://pan.baidu.com/s/1pLdRbdD)
- [微云下载](https://share.weiyun.com/b84783d56c433c9a77d615d021beb7cc)
- 说明:如果下载链接不存在,请发邮件至邮箱:814326663@qq.com,询问最新的下载链接
- aar格式的依赖包下载:[百度云下载](http://pan.baidu.com/s/1hskkWrq),[微云](https://share.weiyun.com/5790593d7c41d1799ce195fa225ca57c)

5.如果要使用自定义控件,请使用maven的方式引用,jar包形式暂只支持工具类的使用

	更新说明(V1.0):

		a.封装了一些常用的工具类,其中util包下的所有工具类为别人一体整理的.
		b.其余上面的工具类为我自己整理集合或书写的.

    更新说明(v1.1,v1.2):
	    新增键盘工具类
	    时间选择器工具类
	    判断重复点击工具类,
	    textview显示自动换行工具类
	    DES加密工具类
	    ImageUtil新增方法
	    文件大小获取工具类
	    文件缓存管理工具类
	    打开QQ咨询企业QQ或者客服的工具类
	    分组排序工具类

	 更新说明(v1.3):
	    新增分组排序工具类
	    新增吐司工具类
	    新增 double保留2为小数或加前缀后缀的工具类

	 更新说明(v1.4):
	    在util包下的AppUtils类里面增加4个方法
	    在weiht里面增加一个自定义的textview
	    view包下增加2个关于文字排版的工具类

	 更新说明(v1.5):
	    新增侧滑删除的父布局空间
	    侧滑删除的listview
	    圆弧形进度条
	    增加一个时光宝盒打开关闭效果的自定义欢迎动画
	    增加一个三个圆动画效果的欢迎动画
	    增加一个动画工具类

	更新说明(v1.6):
	    由于1.5在jitpack.io上打包失败,故新更新1.6
	    增加一个LuBanUtils图片压缩工具类
	    新增一个动画相关的包,包下含有动画相关的类
	    增加一个ARR依赖库的下载地址

	更新说明(v1.7):
	    增加一个爱奇艺加载动画的自定义view-iQiYiLoadingView
	    增加一个自带进度的Imagview 和一个自带进度的蒙版CustomView(需配合imagview或者photoview使用)
	    OkhttpUtil里面新增一个下载进度接口,与一个下载进度类

	更新说明(v1.8):((暂未打包成jar,arr包与上传jitpack.io))
	    增加一个屏幕适配的工具类



具体目录如下:

1.[request](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/request)包下包含有
- [OKhttp](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/request/okhttp) 	OKHTTP请求
- [volley](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/request/volley) volley请求
- [xutils3](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/request/xutils) 	xUtils3请求,请视具体情况适用.

2.[acache](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/acache)包下为缓存工具类或者清理缓存的工具类所在.
- [ACache](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/acache/ACache.java) 缓存工具类
- [DataCacheManager](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/acache/DataCacheManager.java) 缓存管理工具类
- [DataCleanManagerUtils](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/acache/DataCleanManagerUtils.java) 缓存清理工具类
- [PreferenceManager](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/acache/PreferenceManager.java) sp管理工具类
- [PreferencesUtils](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/acache/PreferencesUtils.java) sp工具类
- [UserUtils](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/acache/UserUtils.java) 用户名与密码保存工具类

3.[permission](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/permission)包下为抽离环信的权限判断与请求的工具类.

4.[storage](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/storage)包下为SDCard相关的工具类

5.[media](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/media)包下包含有

- [AudioRecoderUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/media/AudioRecoderUtils.java)录音/或播放工具类
- [glide](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/media/GildeTools)工具类
- [volley](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/media/VolleyTools)加载图片的工具类
- [LuBanUtils](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/media/LuBanUtils.java) 鲁班图片压缩工具类,支持单张或多张上传(多张上传仅支持file形式的list)
- 其他关于[bitmap或者drawable](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/media)的工具类

6.[string](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/string)包下包含有

- [AESUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/string/AESUtils.java)(AES加密解密工具类)
- [CyptoUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/string/CyptoUtils.java)(DES加密工具类)
- [MD5](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/string/MD5.java)(MD5加密工具类)
- [AnimUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/string/AnimUtils.java) 动画工具类(仿UC欢迎动画)具体使用方法参照:[使用方法](https://github.com/qtstsq55/SimilarUCBrowserWizardGuideAnimator/blob/master/app/src/main/java/com/example/ucwizard/MainActivity.java)
- [其他工具类](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/string).具体自己看源码

7.[sys](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/sys)包下含有

- [NetUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/NetUtils)	抽离环信的网络判断工具类
- [MapUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/MapUtils.java)	开启地图导航/判断是否安装有地图APP的工具类	 
- [SetTelCountTimer](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/SetTelCountTimer.java)	倒计时button的工具类 
- [SystemUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/SystemUtils.java)	关于系统信息的工具类 
- [Validator](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/Validator.java)	判断工具类,如手机号,E_mail等
- [ZipUtil](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/ZipUtil.java)	压缩/解压工具类 
- [ReflectionUtil](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/ReflectionUtil.java)	反射工具类 
- [ScreenUtil](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/ScreenUtil.java)	屏幕工具类
- [StatusBarUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/StatusBarUtils.java)和[StatusBarUtil](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/StatusBarUtil.java)及[StatusBarView](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/StatusBarView.java)	沉浸式状态栏工具类
- [DataUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/DataUtils.java)和[DateUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/DateUtils.java)		时间处理工具类	
- [SoftKeyboardUtil](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/SoftKeyboardUtil.java)  键盘工具类
- [TimePickUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/TimePickUtils.java)  时间选择器工具类
- [ToastUtils](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/ToastUtils.java) 吐司工具类
- [SupportMultipleScreensUtil](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/sys/SupportMultipleScreensUtil.java) 屏幕适配的工具类

   用法如下图:
   [查看图片1](https://github.com/DaysLater/AndroidUtils/blob/master/img/how.png)
   ![image](https://github.com/DaysLater/AndroidUtils/blob/master/img/how.png)
   [查看图片2](https://github.com/DaysLater/AndroidUtils/blob/master/img/how2.png)
 ![image](https://github.com/DaysLater/AndroidUtils/blob/master/img/how2.png)

8.[weight](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/weight)包下自定义控件,包含有

a.下拉刷新上拉加载: [swipyrefresh](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/weight/swipyrefresh)包
- [CircleImageView](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/swipyrefresh/CircleImageView.java)  圆形imageview
- [MaterialProgressDrawable](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/swipyrefresh/MaterialProgressDrawable.java)  Material效果的progressbar
- [SwipyRefreshLayout](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/swipyrefresh/SwipyRefreshLayout.java) 下拉刷新/上拉加载更多
- [SwipyRefreshLayoutDirection](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/swipyrefresh/SwipyRefreshLayoutDirection.java) 配合下拉刷新/上拉加载更多使用

b.webview相关: [webView](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/weight/webView)包
- [scrollWebview](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/webView/ScrollWebView.java)  可滑动的webview
- [MyWebViewClient](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/webView/MyWebViewClient.java) 帮助WebView处理各种通知、请求事件的(带dialog)
- [MyWebChromeClient](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/webView/MyWebChromeClient.java) 辅助WebView处理Javascript的对话框，网站图标，网站title，加载进度

c.其他自定义view: [numal](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/numal)包
- [SelectTextView](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/numal/SelectTextView.java) 关于超文字显示的textview  文字点击显示更多/隐藏一部分
- [SwipeListLayout](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/numal/SwipeListLayout.java) 侧滑删除的layout,必须是父类layout,需配合 SwipeSlideListener 使用
- [SwipeSlideListener](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/numal/SwipeSlideListener.java) 侧滑删除layout的监听器  侧滑Layout需与之配合使用 内含一个传入litview的滑动监听
- [ListSlideView](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/numal/ListSlideView.java) 自定义的侧滑listView 需配合item布局使用
- [RoundProgressView](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/numal/RoundProgressView.java) 自定义圆弧进度条
- [BoxLid](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/numal/BoxLid.java) 自定义欢迎动画(时光宝盒样式)具体动画效果请点击:[动画效果](https://github.com/nextdever/BoxLid/blob/master/screenshots/boxlid.gif)
- [SplashView](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/numal/SplashView.java) 三个圆的欢迎动画
- [iQiYiLoadingView](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/numal/iQiYiLoadingView.java)仿爱奇艺的视频加载动画


    iQiYiLoadingView的自定义属性说明:
    //设置三角形的颜色
    app:innerTriangleColor="@android:color/holo_orange_dark"
    //设置三角形外接圆的半径
    app:innerTriangleRadius="8dp"
    //设置外面进度条的颜色
    app:outerCircleColor="@android:color/holo_blue_dark"
    //设置外面进度条的半径
    app:outerCircleRadius="16dp"
    //设置是否需要背景
    app:isNeedBackground="false"
    //设置背景的颜色
    app:backgroundColor="@android:color/holo_orange_light"

- [ProcessImageView](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/numal/ProcessImageView.java) 自带进度的ImageView
- [CustomView](https://github.com/DaysLater/AndroidUtils/blob/master/app/src/main/java/com/example/user/utils/weight/numal/CustomView.java) 自带进度的View,需配合Imagview或者Photo使用,建议使用Relativelayout和framelayout中使用(宽高与设置的imageview或者photoview一致)

9.[util](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/util)包为别人一体整理的工具类

10.[view](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/view)包下含有
- [AnimUtils](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/view/AnimUtils.java) 动画工具类,按照参数传就OK
- [ViewFindUtils](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/view/ViewFindUtils.java) 简写ViewHodler 和findViewById
- [AutoSpliText](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/view/AutoSpliText.java) 文本显示自动换行工具类
- [CommonUtils](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/view/CommonUtils.java) 判断是否是重复点击的工具类
- [OpenQToChat](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/view/OpenQToChat.java) 打开企业QQ咨询的工具类
- [ComparatorUtil](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/view/ComparatorUtil.java) 分组排序工具类
- [NumberFormat](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/view/NumberFormat.java) double保留2为小数或加前缀后缀的工具类
- [AnalysisHTML](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/view/AnalysisHTML.java)  关于文字排版的工具类
- [PaintViewUtil](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/view/PaintViewUtil.java) 关于文字排版的工具类

11.[file](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/file) 包下为文件相关工具类
- [AttachmentStore](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/file/AttachmentStore.java) 把附件保存到系统中
- [FilePathUtils](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/file/FilePathUtils.java) 获取文件地址的工具类
- [FileUtil](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/file/FileUtil.java) 文件工具类
- [OpenFileUtils](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/file/OpenFileUtils.java) 打开文件工具类

12.[loaddrawable](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/loaddrawable) 关于加载动画及进度动画的工具类
- [circle](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/loaddrawable/circle) 关于圆的进度动画或加载动画
- [goods](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/loaddrawable/goods) 关于水波/气球进度动画或加载动画
- [scenery](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/loaddrawable/scenery) 关于风扇形式的加载进度/日夜交替的动画
- [LoadingDrawable](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/loaddrawable/LoadingDrawable.java) 自定义加载动画的drawable
- [LoadingRenderer](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/loaddrawable/LoadingRenderer.java) 加载动画的基础类
- [LoadingRendererFactory](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/loaddrawable/LoadingRendererFactory.java) 加载动画的工厂类
- [LoadingView](https://github.com/DaysLater/AndroidUtils/tree/master/app/src/main/java/com/example/user/utils/loaddrawable/LoadingView.java) 加载动画的View,需要在XML文件中引用

如何使用?

1.首先在你的根目录的build.gradle添加这一句代码

	allprojects {
  		 repositories {
   			...//missing more
   			maven { url 'https://jitpack.io' }
		    }
     	}

2.在app目录下的build.gradle添加依赖使用

   		dependencies {
			//copy to your app build 
   			compile 'com.github.DaysLater:AndroidUtils:v1.7'
   			// 如要关联之前的依赖 请修改
   			//compile 'com.github.DaysLater:AndroidUtils:v1.x'
   			//为对应的版本号.工具类版本从1.0开始
   		}

写在后面:

1.在1.0完成后,还在慢慢增加常用工具类,多谢Android交流群里面的群友的支持.

2.感谢交流群_小戴,交流群_三金的工具类支持与奉献.

3.感谢[NineOldAndroid](https://github.com/JakeWharton/NineOldAndroids),[SimilarUCBrowserWizardGuideAnimator](https://github.com/qtstsq55/SimilarUCBrowserWizardGuideAnimator),[LoadingDrawable](https://github.com/dinuscxj/LoadingDrawable),[多谢谷歌小弟的博客与视频](http://blog.csdn.net/lfdfhl/article/details/52735103)等开源项目作者的贡献.

