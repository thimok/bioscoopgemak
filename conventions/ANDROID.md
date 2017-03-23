# Android naming conventions

## Layout names

```xml
activity_name__abbreviated_type__name_of_object
```

Example: activity_main__tv__first_name (for a TextView in the activity_main layout meant for first names)

Rules:
- lowercase
- underscores for the same section, double underscores between different sections

Most common types:
- TextView: tv
- ImageView: iv
- EditText: et
- ListView: lv
- Button: btn


## Java variables

```java
private TextView firstName;
```

Rules:
- lowerCamelCase

## Java classes

```java
public class MyClass {
	//Class content
}
```

Rules:
- UpperCamelCase