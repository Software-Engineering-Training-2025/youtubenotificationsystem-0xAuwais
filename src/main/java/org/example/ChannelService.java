package org.example;

import org.example.observer.Observer;
import org.example.subject.Channel;
import org.example.subject.Subject;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ChannelService {
    private final Map<String, Channel> channels = new HashMap<>();
    public void createNewChannel(Channel channel) {
        if(channels.containsKey(channel.getName())){
            System.out.println("That channel name is already taken");
            return;
        }
        channels.put(channel.getName(), channel);
    }
    public void createChannel(String channel) {
        Channel channelObj = new Channel(channel);
        createNewChannel(channelObj);
    }
    public void deleteChannel(String channel) {
        if(channels.containsKey(channel)){}
        channels.remove(channel);

    }
    public Set<String> listChannels() {
        return new HashSet<>(channels.keySet());
    }
    public void subscribe(String channel, Observer observer) {
        final Channel channelObj = channels.get(channel);
        if(channelObj == null){
            System.out.println("Channel " + channel + " not found");
        }
        else {
            channelObj.subscribe(observer);
        }
    }

    public void upload(String channel, String message) {
        final Channel channelObj = channels.get(channel);
        if(channelObj == null){
            System.out.println("Channel " + channel + " not found");
        }
        else {
           channelObj.uploadVideo(message);
           channelObj.notifyObservers(channel+" "+message);
        }
    }
}
