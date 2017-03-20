# Gradle管理多项目示例

IDE是Eclipse

## 依赖关系

```
Root project 'gradle-multi-projects-example'
+--- Project ':prj-a'
\--- Project ':prj-b'
```

* `prj-a`和`prj-b`，都依赖`user-defined-lib-folder`下的`commons-math3-3.6.1.jar`包
* `prj-b`依赖`prj-a`

## 项目结构

```
.
├── build.gradle      # root-project和sub-projects的公共配置 [1]
├── prj-a
│   ├── build.gradle  # prj-a的特定配置
│   └── user-defined-src-folder
├── prj-b
│   ├── build.gradle  # prj-b的特定配置 [2]
│   └── src
├── settings.gradle   # 配置子项目
└── user-defined-lib-folder
```

* [1] `[build.gradle](./build.gradle)`

```
...

dependencies {
        // 配置本地的全局jar目录
        ext.rootProjectLibs = new File(rootProject.rootDir, 'user-defined-lib-folder').getAbsolutePath()
        ext.jarTree = fileTree(dir: rootProjectLibs, include: '**/*.jar')

        compile jarTree
    }

...
```

* [2] `[prj-b/build.gradle](/prj-b/build.gradle)`

```
...

sourceSets {
    main {
        java {
            srcDirs = ['src']  // 指定源代码目录
        }
    }
}

buildDir = 'bin'  // 指定编译输出目录

dependencies {
    compile project(":prj-a")   // 指定依赖关系，当前项目依赖prj-a
}

...
```

## 参考
[someok](https://github.com/someok)/[gradle-multi-project-example](https://github.com/someok/gradle-multi-project-example)

