@ECHO off

"C:\Program Files\Java\jdk1.8.0_162\bin\java.exe" 

java -cp  target\Thoth-v1.jar dcct1.Thoth.App -d jdbc:sqlite:database/Thoth.db

java -cp  target\Thoth-v1.jar dcct1.Thoth.App -v

java -cp  target\Thoth-v1.jar dcct1.Thoth.App -version

java -cp  target\Thoth-v1.jar dcct1.Thoth.App -h

java -cp  target\Thoth-v1.jar dcct1.Thoth.App 
PAUSE
