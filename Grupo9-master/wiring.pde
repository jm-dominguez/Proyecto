    #include <string.h>
     
    int tempPin = 24;
    int ruidoPin = 25;
    int luzPin = 26; 
    int coPin = 27;
    
    double v = 0;
    double v1 = 0;
    double a = 0.07;     //Resistencia en oscuridad en KΩ
    double b = 7.5;
     
     int tempC = 0; //cada 1000
     int ruido = 0; //cada 5000
     int luz = 0;  //cada 60000
     int co = 0;  //cada 30000
     
     int tiempo = 0;
     
     String tempUnit = "C";
     String ruidoUnit = "dB"; 
     String luzUnit = "Lux"; 
     String coUnit = "ppm"; 
     
    
     String array[2] = {"", ""};
     
     int i = 0;
    
     void setup() { 
       
         Serial.begin(9600);
        
     }
     
     void loop() 
     {  
       tempC = analogRead(tempPin);
       tempC = (4.9 * tempC * 100.0)/1024.0; 
       array[0] = String(tempC);
       array[1] = String(tempUnit);
       for(int i = 0; i < 2; i++)
       {
         Serial.print(array[i]);
         Serial.print("\t");
       }
       Serial.println("");
       
       if(tiempo % 5 == 0)
       {
       ruido = analogRead(ruidoPin);
       array[0] = String(ruido);
       array[1] = String(ruidoUnit);
       for(int i = 0; i < 2; i++)
       {
         Serial.print(array[i]);
         Serial.print("\t");
       }
       Serial.println("");
       }
      if(tiempo % 60 == 0)
      { 
       luz = analogRead(luzPin);
       v1= a*luz + b;
       array[0] = String(v1);
       array[1] = String(luzUnit);
       for(int i = 0; i < 2; i++)
       {
         Serial.print(array[i]);
         Serial.print("\t");
       }
       Serial.println("");
       tiempo = 0;
      }
      if(tiempo % 30 == 0)
      {
       co = analogRead(coPin);
       array[0] = String(co);
       array[1] = String(coUnit);
       for(int i = 0; i < 2; i++)
       {
         Serial.print(array[i]);
         Serial.print("\t");
       }
       Serial.println("");
      }
       Serial.println("");
       delay(1000);
       tiempo++;
     }
    
 
     

