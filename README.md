# SGraphicsRecursive
Same as SuperTapood/SGraphics (a project I'm a part of), but using a Recursive Drawing method!

Options: (Found at SPixelGrid.java):
- final int defaultJump - for printing purposes. Defines the default jump between columns, pixels, and more.
- final int delayBetweenResulotionChanges - Delay measured in Miliseconds for the Resulotion to change (get 2x better, and 4x slower).
- final double perlinMultiplier - The smaller the number, the less messy-looking the Grid is.
- final int threshold - Ranges 0 to 255. Defines a threshold for the color values. (Is applied with the sigmoid)
- final int mode - Can be Const.RGB or Const.GRAYSCALE. Defines the current drawing method, whether to use 3 differnt perlin spaces or 1.
