# Configuring Dakboard
***
### Configure Dakboard API Spring Boot App

deploy dakboard-api.jar to /opt/dakboard-api
create dakboard-api.service file at /etc/systemd/system
```aidl
sudo touch /etc/systemd/system/dakboard-api.service
```
Modify the file with the following content
```aidl
[Unit]
Description=Dakboard API Service
After=network.target

[Service]
Environment="DISPLAY=:0.0"
ExecStart=java -Xmx1024M -jar dakboard-api-0.1.0.jar  
WorkingDirectory=/opt/dakboard-api
StandardOut=/opt/dakboard-api/service.log
StandardError=/opt/dakboard-api/service.log
Restart=always
User=pi

[Install]
WantedBy=multi-user.target
```
Start Service with 

```aidl
sudo systemctl start dakboard-api.service
```

Ensure Api is working as expected

Enabled Service on restart with the followign command
```aidl
sudo systemctl enable dakboard-api.service
```
***
### Remove Mouse Cursor on no activity

Install Unclutter from apt-get
```
sudo apt-get install unclutter
```
***
### Configure Chromium Startup on Boot
[Example modifed from following statck exchange article](https://raspberrypi.stackexchange.com/questions/40631/setting-up-a-kiosk-with-chromium/40745#40745?newreg=c9704e6834f541ffb621ede086bdccc2)

Create directory with file named autostart

```aidl
mkdir -p /home/pi/.config/lxsession/LXDE-pi/
touch /home/pi/.config/lxsession/LXDE-pi/autostart
```
Modify values for file to be 
```aidl
@lxpanel --profile LXDE-pi
@pcmanfm --desktop --profile LXDE-pi
#set screensave to never turn on
@xset s 0
#set energy star to never blank the screen
@xset -dbms
#@xscreensaver -no-splash
#wait five seconds before hiding the cursor forever
@unclutter -idle 5
@chromium-browser --start-fullscreen --app=https://dakboard.com/screen/uuid/5bac333e-ff809-e2f6-19d54b7dd01b
```
***
### Set Screen Rotation to 90 Degrees

Within the terminal on your Raspberry Pi, begin editing the boot configuration file by running the following command.

```aidl
sudo nano /boot/config.txt
```

Modify file to add the following line

```aidl
display_hdmi_rotate=1
```
New Way to rotate screen
DISPLAY=:0 xrandr --output HDMI-1 --rotate left
If I want to use VNC, here are the instructions.

https://www.raspberrypi.org/documentation/remote-access/vnc/#:~:text=VNC%20Connect%20from%20RealVNC%20is,Pi%20should%20you%20want%20to.

Enable VNC Server
```aidl
systemctl start vncserver-x11-serviced.service
```
Disable VNC Server
```aidl
systemctl stop vncserver-x11-serviced.service
```

