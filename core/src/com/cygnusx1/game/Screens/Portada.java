package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cygnusx1.game.CygnusX1;

/**
 * Created by Oscar y adnrey on 17/05/17.
 */
public class Portada implements Screen{
    private CygnusX1 juego;
    private Sprite portada, portada2, portada3, libGdx;
    private SpriteBatch batch;
    public int  timer = 100;
    public int timer2 = 100;
    public int timer3 = 100;
    public int lib = 100;
    private Sound sound;


    public Portada(CygnusX1 j){
        juego = j;
        batch = new SpriteBatch();
        portada = new Sprite(new Texture(Gdx.files.internal("portada.png")));
        portada2 = new Sprite(new Texture(Gdx.files.internal("portada2.png")));
        portada3 = new Sprite(new Texture(Gdx.files.internal("portada3.png")));
        libGdx = new Sprite(new Texture(Gdx.files.internal("libGdx.png")));
        sound =  Gdx.audio.newSound(Gdx.files.internal("1920.mp3"));

    }

    @Override
    public void show(){
        sound.play();
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        if(lib >= 0){
            lib--;
            libGdx.draw(batch);
        }
        else if(timer >= 0){
            timer--;
            portada.draw(batch);
        }
        else if(timer2 >= 0){
            timer2--;
            portada2.draw(batch);
        }
        else if(timer3 >= 0){
            timer3--;
            portada3.draw(batch);
        }
        batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            this.dispose();
            juego.setScreen(new Menu(juego));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        batch.dispose();
        sound.dispose();
    }
}
