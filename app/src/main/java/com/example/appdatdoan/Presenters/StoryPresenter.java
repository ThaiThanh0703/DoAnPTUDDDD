package com.example.appdatdoan.Presenters;

import com.example.appdatdoan.Models.Story;
import com.example.appdatdoan.Interfaces.IStory;
import com.example.appdatdoan.Interfaces.StoryView;

public class StoryPresenter implements IStory {

    private Story story;
    private StoryView callback;

    public StoryPresenter(StoryView callback){
        story = new Story(this);
        this.callback = callback;
    }

    public void HandleGetStory(String iduser){
        story.HandleGetStory(iduser);
    }
    @Override
    public void getDataStory(String noidung) {
        callback.getDataStory(noidung);
    }
}
