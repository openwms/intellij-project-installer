# intellij-project-installer
This project builds an installer that builds a personalized IntelliJ project setting file.

#### Licence GPLv2 -> Use it but don't extend it without pushing back your changes!

# Why?
When you're working with JetBrains IntelliJ in a team you need to share common project settings between all developers.
This works fine by using IntelliJ "Export Settings" function until you have project settings personalized for each
developer. For example: Whenever developer's name (not the OS login name) should appear in a file header, or developer's
email address should be part of the class'es javadoc, you need to post-process IntelliJ settings after exporting them
from the IDE. That's why this project is for!

# How?
As usual I love to wrap the wrapper - same as here. The process is like as follows.
 -  Run the IntelliJ Project Installer jar or exe file
 -  Go through the installation process and provide all mandatory fields
 -  The installation routine, running at the end of the process, will personalize IntelliJ settings and produce an `intellij-settings.jar` file and the end
 -  This generated JAR file can be easily imported by the developer that ran the installer

![1]

![2]

![3]

![4]

![5]

![6]

[1]: docs/1.png
[2]: docs/2.png
[3]: docs/3.png
[4]: docs/4.png
[5]: docs/5.png
[6]: docs/6.png