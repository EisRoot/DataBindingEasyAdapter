# DataBinding_EasyAdapter
能使你非常轻松的在DataBinding中使用listView和RecyclerView

![gif](/Demo.gif)
## 下载
首先，你得使用 [谷歌的 Data Binding 框架](https://developer.android.com/tools/data-binding/guide.html)(如果你正在的使用的话
你可以跳过这一步)

接着,把下面这一行加入你的项目的依赖里去:

```groovy
compile'com.databindingadapter.eis:databindingeasyadapter:1.0.0'
```

##使用范围

首先声明一个继承自ViewModel的类，itemView。将它绑定到相应的布局文件（item布局文件）中去。


```xml

<layout xmlns:app="http://schemas.android.com/apk/res-auto">
    <data>
        <variable
            name="itemImage"
            type="com.databindingadapter.eis.databindingadapter.ItemImageType"/>
    </data>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:background="#738ee4"
    android:gravity="center"
    android:layout_margin="10dp"
    app:click="@{itemImage.click}"
    android:layout_height="140dp">
    <ImageView
        android:layout_width="35dp"
        android:layout_height="35dp"
        android:src="@drawable/icon_headphone"/>

</LinearLayout>
</layout>

```
**setBr_id()** 需要itemView对应的variable name.**setLayout_id()** 需要对应的布局文件名.
```java
public class ItemImageType extends ViewModel {
    
    {
        setLayout_id(R.layout.item_image_type);
        setBr_id(BR.itemImage);
    }
    private View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"the position is"+getPositon(),Toast.LENGTH_SHORT).show();
        }
    };

    public View.OnClickListener getClick() {
        return click;
    }

    public void setClick(View.OnClickListener click) {
        this.click = click;
    }
}
```

当你完成了以上的步骤，你就可以在你的Activity中使用它了。

如果你想显示多Type的列表的话，应当在创建几个类似的itemView。

在你的activity中使用的步骤：

第一步 使用ObservableArrayList来做itemView的集合，这个集合必须初始化，否则会爆空指针异常

```java
public class MainActivityViewModel extends BaseObservable {
    public ObservableArrayList<ViewModel> viewModels = new ObservableArrayList<>();
    public int span=3;
}
```

第二步 将ObservableArrayList绑定到你列表控件上去

```xml
<android.support.v7.widget.RecyclerView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:RA_bind="@{main.viewModels}">
```


第三步 在Databinding的时候，将你实例化的itemView放入ObservableArrayList集合

```java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListViewBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_list_view);

        MainActivityViewModel viewModel=new MainActivityViewModel();
        viewModel.viewModels.add(new ItemImageType());
        viewModel.viewModels.add(new ItemTextType());
        viewModel.viewModels.add(new ItemMixupType());
        viewModel.viewModels.add(new ItemTextType());
        viewModel.viewModels.add(new ItemTextType());
        viewModel.viewModels.add(new ItemTextType());
        viewModel.viewModels.add(new ItemMixupType());
        viewModel.viewModels.add(new ItemImageType());
        viewModel.viewModels.add(new ItemMixupType());
        binding.setMain(viewModel);

    }
```

最后编译运行，就能看到效果了

ListView 的使用如下:
```xml
<ListView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:BA_bind="@{main.viewModels}">
```

网格式RecyclerView 的使用如下:

```xml
 <android.support.v7.widget.RecyclerView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:RA_bind_G="@{main.viewModels}"
            app:RA_span="@{main.span}"
            >
```
瀑布式RecyclerView 的使用如下:

```xml
  <android.support.v7.widget.RecyclerView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:RA_bind_S="@{main.viewModels}"
            app:RA_span="@{main.span}">
```

你也可以在你的itemView中使用getPosition这个方法获取当前item在list中的位置。
还可以使用“app:click”将OnClickListener绑定到你的布局文件中去。

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:background="#738ee4"
    android:gravity="center"
    android:layout_margin="10dp"
    app:click="@{itemImage.click}"
    android:layout_height="140dp">
```

还有什么想了解的，看代码吧
邮箱：j@bns.so

## License

    Copyright 2015 Evan Tatarka

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
