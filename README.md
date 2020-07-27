### 在recycler-view-practice2的基础上进行修改

### 断开VPN，模拟器能正常联网，加载图片成功
![avatar](/result/result-image.png)

### 加载图片不成功报错

![avatar](/result/result.png)

```
W/Glide: Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored
```

```
W/Glide: Load failed for https://loremflickr.com/180/180?lock=2 with size [131x131]
    class com.bumptech.glide.load.engine.GlideException: Failed to load resource
    There was 1 cause:
    java.net.UnknownHostException(Unable to resolve host "loremflickr.com": No address associated with hostname)
     call GlideException#logRootCauses(String) for more detail
      Cause (1 of 1): class com.bumptech.glide.load.engine.GlideException: Fetching data failed, class java.io.InputStream, REMOTE
    There was 1 cause:
    java.net.UnknownHostException(Unable to resolve host "loremflickr.com": No address associated with hostname)
     call GlideException#logRootCauses(String) for more detail
        Cause (1 of 1): class com.bumptech.glide.load.engine.GlideException: Fetch failed
    There was 1 cause:
    java.net.UnknownHostException(Unable to resolve host "loremflickr.com": No address associated with hostname)
     call GlideException#logRootCauses(String) for more detail
          Cause (1 of 1): class java.net.UnknownHostException: Unable to resolve host "loremflickr.com": No address associated with hostname
I/Glide: Root cause (1 of 1)
```
