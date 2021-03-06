# TextViewHelper version 1.0.0 

**version 1.0.0**

Change the Text Color of a Substring inside Android TextView

![Image of TextViewHelper](https://github.com/milon27/TextViewHelper/blob/master/screenshot.png)

---

## Installation of TextViewHelper

#### 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:\

```
buildscript {
    repositories {
         ....
        maven { url 'https://jitpack.io' }
    }
}

allprojects {
    repositories {
     .......
        maven { url 'https://www.jitpack.io' }
    }
}

```

#### 2. Gradle dependencies

```
  dependencies {
	        implementation 'com.github.milon27:TextViewHelper:1.0.1'
	}
```
---
## Quick start with TextViewHelper
#### step 1:init textView
get textview reference using findViewByID and set text to the textview.
```
    TextView textview=findViewById(R.id.textview);
    textview.setText("Note: This is important Notice,click here");
```
#### step 2:set text color 

TextViewHelper.getInstance(TextView textview)\
setTextColor(int color,int start startIndex,start endIndex)

```
TextViewHelper.getInstance(textview)
          .setTextColor(Color.MAGENTA,0,4)
          .setTextColor(Color.GREEN,10,24)//you can add colorful sub-string as many as you want 
          .draw();
```

#### step 3:set text Clickable  

###### 3.1 you need a ClickableSpan object to make a sub-string clickable.so first create a ClickableSpan object.
```
      ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(getApplicationContext(),"click action",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                //ds.setColor(Color.MAGENTA);//using this you can change the clickable sub-string's text color
                //ds.setUnderlineText(true);//using this you can change the underline state(true/false)
            }
        };
```
###### 3.2 Now using the getInstance method call setTextClickable() and pass ClickableSpan object we just created.
```
    //you can add both textClickable and textColor method at the same time using .(dot) operator
    TextViewHelper.getInstance(txtview)
        .setTextClickable(clickableSpan,31,41).
        draw();
```
---

# ok now you are good to go....

---
## Author
Md jahidul Islam\
IUBAT-CSE\
http://www.m27lab.com/team/md-jahidul-islam/
