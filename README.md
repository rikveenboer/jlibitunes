
Fork of [http://www.dot-totally.co.uk/software/itunescon/](https://web.archive.org/web/20120717045342/http://www.dot-totally.co.uk/software/itunescon/) (now unavailable).

----------

iTunesController
================

iTunes Controller is a Java wrapper package that allows you to control iTunes from your Java application. It uses the excellent JACOB Java-COM Bridge to communicate but provides all the interfaces for you to use straight away without dealing with messy COM objects, variants and dispatch calls. You can control what is playing, manage playlists and various sources (such as the main library or any connected iPod) and control nearly every aspect of the iTunes application. The design of the package and it's available functions very closely follows the original iTunes COM API specification available from Apple.

The project is a work-in-progress, and whilst most of the major functions are already included, several lesser-used functions and interfaces are currently missing from the class. These will be addressed in future releases.

## Documentation ##

All of the functions that have been implemented thus far have been fully documented using a similar fashion to the official iTunes COM SDK documentation. You can find details of all the functions in this API guide:

[com.dt.iTunesController](https://web.archive.org/web/20120717045342/http://www.dot-totally.co.uk/software/itunescon/javadoc-0.2/)

**Examples of use**

Get information about the currently playing track:
	
	iTunes itc = new iTunes();
	ITTrack itt = itc.getCurrentTrack();
	System.out.println("Currently playing:");
	System.out.println("Name:    " + itt.getName());
	System.out.println("By:      " + itt.getArtist());
	System.out.println("Album:   " + itt.getAlbum());

Skip to the next track, wait for 5 seconds and pause:
	
	iTunes itc = new iTunes();
	itc.nextTrack();
	try {
	   Thread.sleep(5000);
	} catch (InterruptedException e) {}
	itc.playPause();

## Event Handling ##

The iTunes Controller package does implement event handling on all but one of the functions the iTunes COM interface provides. By creating a class that implements the iTunesEventsInterface class, and then using iTunes.addEventHandler() function, you can receive events from the iTunes class, such as when tracks change or if the user pauses playback. However, iTunes will only allow one application to receive COM events at once, and if your application doesn't release its COM Thread iTunes will refuse any more connections until iTunes has been closed and reopened. This is most important with using Swing, which will prevent a COM Thread from closing when the application finishes. I will be attempting to introduce measures to combat this, though for now you may have to use the iTunes class in a seperate thread when using Swing interfaces.

## External Sources ##


- [JACOB Project](https://web.archive.org/web/20120717045342/http://sourceforge.net/projects/jacob-project/)

	The JAVA-COM Bridge project that enables COM communication.

- [iTunes COM for Windows SDK](https://web.archive.org/web/20120717045342/http://developer.apple.com/sdk/itunescomsdk.html)

	Official Apple documentation for the COM SDK.
