# LoadingLib

这是一个开源的动画库，动画框架改自另一个开源库，我对其中做了一些修改，在绘制更加复杂的动画的时候，结构更加清晰。<br>
同时，首次通过JitPack来发布开源项目，这个仓库的使用还是很方便的，如何通过JitPack发布开源项目：
https://github.com/GcsSloop/AndroidNote/blob/master/Course/ReleaseLibraryByJitPack.md

## 如何使用
###gradle版本
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```
	dependencies {
	        compile 'com.github.82367825:LoadingLib:v1.0.0'
	}
```

###Maven版本
Step 1. Add the JitPack repository to your build file
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

Step 2. Add the dependency
```
	<dependency>
	    <groupId>com.github.82367825</groupId>
	    <artifactId>LoadingLib</artifactId>
	    <version>v1.0.0</version>
	</dependency>
```

