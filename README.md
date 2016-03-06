# intellij-project-installer
This project builds an executable installer JAR file that is able to build a personalized IntelliJ project setting file.

# Why?
When you're working with JetBrains IntelliJ in a team you need to share common project settings between all developers
(the same is true for other IDE or even w/o IDE as well). This works fine by using IntelliJ "Export Settings" function
until you have your project settings personalized for each developer.
For example: Whenever developer's name (not the OS login name) should appear in a file header, or developer's email
address should be part of the class' javadoc, you need to post-process IntelliJ settings files after exporting them
from the IDE. That's why this project is for!

# How it works
We maintain an already exported set of IntelliJ settings in the `${basedir}/settings` folder. IntelliJ exports general
settings in XML files, those are easy to post-process. This Maven project uses the installer from izpack.org to define
the installer process and although the post-processing of the XML files. How does this installation process works? First
all files under `${basedir}/settings` are copied to the target directory (given by the user). Afterwards all files in
the target directory are scanned for izpack placeholders and values are replaced with user input.

To learn more see the definition of user input panel `${basedir}/resources/userinput.xml` and the install script
`${basedir}/src/izpack/install.xml`.

# Lifecycle

This project was initially created for Eclipse workspaces back in 2008. Just to create a personalized Eclipse workspace.
By the years we extended the installer to install Eclipse versions for all platforms, Maven, Glassfish, personalize
Subversion, etc. Since we're using Jetbrains IntelliJ since for years now and see similar challenges we adopted the
installer. Probably Atlassian Agent Charlie will be helpful in near future to solve this issues.

# How to use it
As usual I love to wrap the wrapper - same as here. The process is as follows.
 -  Run the IntelliJ Project Installer jar or exe file
 -  Go through the installation process and provide all mandatory fields (name, email etc.)
 -  The installation routine, running at the end of the process, will personalize IntelliJ settings and produce an
 `intellij-settings.jar` file at the end
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