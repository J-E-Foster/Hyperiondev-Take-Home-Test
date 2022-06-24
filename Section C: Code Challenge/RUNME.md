# How to install Java and Eclipse

## How to install Java

* Go to [java.com/en/download].
* Click **"Agree and Start Free Download"**:

![](Java-install-images/1.jpg)

* Save file in prefferred location:

![](Java-install-images/2.jpg)

* Run the **.exe** file (double click on it) and click **"Yes"**.
* Tick the **"Change destination folder"** box, click **"Install"**, and wait for installation:

![](Java-install-images/3.jpg)

![](Java-install-images/4.jpg)

* You have successfully installed Java should display after install. Click **"Close"**:

![](Java-install-images/5.jpg)
 	
* To check installation, open **Command Prompt**:

![](Java-install-images/6.jpg)

* Type the following command and press Enter:

```
java -version
```

* The current version should be displayed:

![](Java-install-images/7.jpg)

## How to install Eclipse

To run Java, you need an [**IDE**], we reccommend **Eclipse**.

* Go to [**eclipse.org/downloads**].
* Click "Download":

![](Eclipse-install-images/1.jpg)

* Select Get Eclipse IDE 2021-03 and click **"Download x86_64"**:

![](Eclipse-install-images/2.jpg)

* Save file to preferred location:

![](Eclipse-install-images/3.jpg)
	
* Run the **.exe** file (double click on it) - **eclipseinstaller** should display.

* Select **"Eclipse IDE for Java Developers"**:

![](Eclipse-install-images/4.jpg)

* Choose your destination folder and click **"Install"**:

![](Eclipse-install-images/5.jpg)

* Click **"Accept now"** on the **User Agreement**:

![](Eclipse-install-images/6.jpg)

* Wait for installation and click **"Launch"**:

![](Eclipse-install-images/7.jpg)

![](Eclipse-install-images/8.jpg)

* Choose your destination folder for Eclipse workspace (this will store all your Java projects) and click **"Launch"**:

![](Eclipse-install-images/9.jpg)

* Eclipse Welcome screen should be displayed:

![](Eclipse-install-images/10.jpg)

## How to run the program in Eclipse

* Select **"File > New>Java Project"**:

![](Eclipse-install-images/11.jpg)

* Enter the new project name:

![](Eclipse-install-images/12.jpg)

* If you are asked to enter **New module-info**, select **Don't Create**:

![](Eclipse-install-images/14.jpg)

* If you are asked to **Open Associated Perspective?** just click "No":

![](Eclipse-install-images/15.jpg)

* If you don't see the **Package Explorer** view, select the small **"J"** icon to the right and close **welcome** tab.
* You should see the created folder in the **Package Explorer**.
* Next, expand your new folder, and right-click on the **src** folder.
* Then right-click on **New** and select **Package**:

![](Eclipse-install-images/16.jpg)

* Name the package **numberSayer** - THIS IS VERY IMPORTANT:

![](Eclipse-install-images/17.jpg)

* Now, go to where you saved the repo contents, navigate to the **numberSayer** folder, and copy all three **.java** files:

![](Eclipse-install-images/18.jpg)
	
* Paste them directly into the **numberSayer** package you created earlier. 
* You should see red warning icons.
* Open the **NumberSayerTest.java** class.
* Then hover your mouse over the red line at **org.junit**:

![](Eclipse-install-images/19.jpg)

* You should see a popup **The import org.junit cannot be resolved**.
* Click **Fix project setup**:

![](Eclipse-install-images/20.jpg)

* Next add **Junit 5** to your project's build path:

![](Eclipse-install-images/21.jpg)

* You should now see that the red warning icons have disappeared.
* You can now run the code by opening the **Main.java** class and selecting the green play icon **Run**:

![](Eclipse-install-images/22.jpg)

* You can also run the test file by going back to the **NumberSayerTest.java** tab and selecting **Run**.

And that's it! You're all set up!

