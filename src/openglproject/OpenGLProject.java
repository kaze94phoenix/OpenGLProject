/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package openglproject;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
/**
 *
 * @author Gaara-X
 */
public class OpenGLProject {

    /**
     * @param args the command line arguments
     */
    //Display
    public static void main(String[] args) {
       createDisplay();
       //createGL();
       loop();
       cleanUP();
       
       
    }
    
    public static void createDisplay(){
         try {
            // TODO code application logic here
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(OpenGLProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void loop(){
         Camera cam = new Camera(70,(float)Display.getWidth()/(float)Display.getHeight(),0.3f,1000);
        float x=0;
         while(!Display.isCloseRequested()){
         glClear(GL_COLOR_BUFFER_BIT);
         glLoadIdentity();
         cam.useView();
         
         glPushMatrix();
            
            glTranslatef(0,0,-10);
            glRotatef(x,1,0,1);
            glBegin(GL_QUADS);
            
            //Face 1
            glColor3f(0.3f, 0.75f, 1.5f);
            glVertex3f(-1, -1,1);
            glVertex3f(-1, 1,1);
            glVertex3f(1, 1,1);
            glVertex3f(1, -1,1);
            
            //Face 2
            glColor3f(0.3f, 0.55f, 1.5f);
            glVertex3f(-1, -1,-1);
            glVertex3f(-1, 1,-1);
            glVertex3f(1, 1,-1);
            glVertex3f(1, -1,-1);
            
            //Face 3
            glColor3f(0.7f, 0.75f, 1.5f);
            glVertex3f(-1, -1,-1);
            glVertex3f(-1, -1,1);
            glVertex3f(-1, 1,1);
            glVertex3f(-1, 1,-1);
            
            //Face 4
            glColor3f(0.3f, 0.75f, 1.5f);
            glVertex3f(1, -1,-1);
            glVertex3f(1, -1,1);
            glVertex3f(1, 1,1);
            glVertex3f(1, 1,-1);
            
            //Face 5
            glColor3f(0.56f, 0.75f, 1.5f);
            glVertex3f(-1, -1,-1);
            glVertex3f(1, -1,-1);
            glVertex3f(1, -1,1);
            glVertex3f(-1, -1,1);
            
            //Face 6
            glColor3f(0.3f, 1.75f, 1.5f);
            glVertex3f(-1, 1,-1);
            glVertex3f(1, 1,-1);
            glVertex3f(1, 1,1);
            glVertex3f(-1, 1,1);
            
            glEnd();
            glPopMatrix();
            x+=0.1f;
            Display.update();
            
            
            
        }
    }
    
//    public static void createGL(){
//        glMatrixMode(GL_PROJECTION);
//        glLoadIdentity();
//        glOrtho(0, Display.getWidth(), 0, Display.getHeight(),-1, 1);
//        glMatrixMode(GL_MODELVIEW);
//        glClearColor(0, 0, 0,1);
//        glDisable(GL_DEPTH_TEST);
//    }
    
    public static void cleanUP(){
        Display.destroy();
    }
}
