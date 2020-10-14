# SGraphicsRecursive
### Using a Recursive Drawing Method and a Perlin-Noise Generated Picture!
#### by @ShZil

#### Options: (Found at SPixelGrid.java):
```java
final int defaultJump
```
for printing purposes. Defines the default jump between columns, pixels, and more.
```java
final int delayBetweenResolutionChanges
```
Delay measured in MILISECONDS for the Resolution to change (get 2x better, and 4x slower).
```java
final double perlinMultiplier
```
The smaller the number, the less messy-looking the Grid is.
```java
final int threshold
```
Ranges `0` to `255`. Defines a threshold for the color values (Is applied with the sigmoid).
```java
final int mode
```
Can be `Const.RGB` or `Const.GRAYSCALE`. Defines the current drawing method, whether to use 3 different Perlin-Spaces or 1.

---------------------

**Based on the code from ["SGraphics by ShZil & SuperTapood"](https://github.com/SuperTapood/SGraphics).**
Most of the code was removed (due to loss of necessity).

---------------------

## Instructions (to run the code on your own computer):
1. Download the code from [this repository](https://github.com/ShZil/SGraphicsRecursive.git) you're in.
2. Open the Command Line (Windows+R, type "cmd", press enter, or by any other means).
The next three steps can be skipped if you open the repository command line:
3. Find the repository folder on your PC using File Explorer.
4. Copy the path to your clipboard.
5. In the open CMD Window, write the command `cd <paste the path>`, remove any `"` if there are, file extentions (such as `.zip` or `.java`) and file names (cd accepts folders only) and press Enter.
6. What you should now see in the CMD (or something similar): `C:\Users\ShZil\github\SGraphicsRecursive>`.
7. Write the following commands (press Enter after each command):
```
> javac *.java -d a
> cd a
> java Main
```
8. The code should compile and run without problems, and **you'll see the animation**.
You can resize the panel, though it will only change in the next frame or drawing cycle.
Clicking with the mouse on the drawing will cause it to render again.

###### Copyright © 2020 ShZil All Rights Reserved.
