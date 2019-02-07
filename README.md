"# VpnChecker"

For Running Code :-

1:  Create Object of VpnRequest:
2: And then Call GetThread() is the Method
3: it will give you thread object contain all details
4: then you can call it:-
for eg:-
          VpnRequest vpnRequest=new VpnRequest();
           Thread t=vpnRequest.GetThread();
              t.Proxy;   //gives you true or false means are you using proxy/vpn or not
   
        t.IpAddress; //returns ip address of device currently using 

//Note that it give you blank if data is not available but works fine all time
       t.Org;
            t.Country;
         t.Region;
        t.Timezone;
        t.City;
     


  




How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.nikm1995:VpnChecker:1.1.3'
	}
Share this release:

Link
That's it! The first time you request a project JitPack checks out the code, builds it and serves the build artifacts (jar, aar).

If the project doesn't have any GitHub Releases you can use the short commit hash or 'master-SNAPSHOT' as the version.
