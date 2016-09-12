# DataBinding_EasyAdapter
an easy way to use multi-type listView or recyclerView in Data Binding for android developer.

![gif](/Demo.gif)
## Download
First,you should use [the google's Data Binding framework](https://developer.android.com/tools/data-binding/guide.html)(If you are useing it,you could skip this step)

Then,Add this line to your denpencie group:

```groovy
compile'com.databindingadapter.eis:databindingeasyadapter:1.0.0'
```

##Useage

You should provide a itemView extends ViewModel. and bind it to your xml.


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
**setBr_id()** requires itemView's variable name.**setLayout_id()** requires itemView's xml.
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
when you finsh those steps above,you can use it in your activity without warried about creating a baseadapter.
If you want to show mutli-type in your list,creat more ’itemView‘.

In Order to use in your activity,it requires:

Step1 :Use 'ObservableArrayList'(it will updata your view automatically) to collcet those 'ItemView'(Any Class extends from ViewModel is OK);
```java
public class MainActivityViewModel extends BaseObservable {
    public ObservableArrayList<ViewModel> viewModels = new ObservableArrayList<>();
    public int span=3;
}
```

Step2 :Bind ’ObservableArrayList‘ to your recyclerView

```xml
<android.support.v7.widget.RecyclerView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:RA_bind="@{main.viewModels}">
```

Step3:Add 'ItemView' to your 'ObservableArrayList'.

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

And finally,you could see it works on your project.

ListView should be used like this:
```xml
<ListView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:BA_bind="@{main.viewModels}">
```

RecyclerView with GridLayoutManager shoule be used like this:

```xml
 <android.support.v7.widget.RecyclerView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:RA_bind_G="@{main.viewModels}"
            app:RA_span="@{main.span}"
            >
```
RecyclerView with StaggeredGridLayoutManager shoule be used like this:

```xml
  <android.support.v7.widget.RecyclerView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:RA_bind_S="@{main.viewModels}"
            app:RA_span="@{main.span}">
```

you could use 'getPosition()' in 'itemView' to get this item's posititon of its' list.
And you could use ’app:click’ to set an OnClickListener in your item layout:
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:background="#738ee4"
    android:gravity="center"
    android:layout_margin="10dp"
    app:click="@{itemImage.click}"
    android:layout_height="140dp">
```

More details,you could see my Demo

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
