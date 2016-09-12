# DataBinding_EasyAdapter
an easy way to use multi-type listView or recyclerView in Data Binding for android developer.
## Download
First,you should use [the google's Data Binding framework](https://developer.android.com/tools/data-binding/guide.html)(If you are useing it,you could skip this step)

Then,Add this line to your denpencie group:

```groovy
compile'com.databindingadapter.eis:databindingeasyadapter:1.0.0'
```

##Useage

You should provide a itemView extends ViewModel which bind to your xml.**setBr_id()** need variable name


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

