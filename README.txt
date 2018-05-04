My picture is zucc.png First, the method lizardIFY makes the image more green by multiplying the green value by 1.5
The next manipulation is 2 mirrors. I use a mirror point to mirror the left side of zucc.png to the right side. Then I
mirror the top half to the bottom half. Both are done using nested loops that only go to half the image then copy the 
color to of each pixel to the corresponding pixel on the other half of the image.
My next method is the randomPlacement method which runs a loop n number of times (n being th enumber of pixels in the picture).
it takes random pixels and places them in random positions. It turned out to make a static looking version of the image.
Next, the recursivePaste method coppies every other pixel to make a smaller image and pastes it at the top right corner of the image.
In order to put it there, I took the interval (represents how many times smaller the image is compared to the original) and
I divide the pixels of the original by the interval. Then, I multiply them by interval-1 to get the starting x for the small image.
My next method is the blend method. I place the second image in the middle by subtracting the width or height of the original
by the width or height of the second, then I divide by 2 to put the image in the middle. T blend it, i make the color of each overlapping
pixel 60% of th esecond images rgb values and 40% of the original image's rgb values.
The next image is the original.
The next image is the negative one. This one is made by subtracting 255 from the rgb values of each color, then multiplying by -1.
The second to last image is the all method. this is a combination of both mirror methods (vertical an dhorizontal), then lizardIFY,
an dthe n the negative method.
The last image is the full mirror of the original the making it recursive. To make this, instead of copying each pixel to the corresponding pixel on the
othe r side of the mirror point, I made a Color object to hold the rgb values the second pixel. Then I made the color of the 2nd pixel 
the same color as the first pixel. The I used the Color object to make the color of the first pixel the color of the second. After that, i used th e shepardFairey 
method which convers the pixels to grayscale then, depending on how bright or dar the color is, changes the pixel to one of three colors. 
Then, I used the RecursivePasteLeft method which does th esame thing as the recursive paste earlier, except it doesn't move the smaller images to the left.



