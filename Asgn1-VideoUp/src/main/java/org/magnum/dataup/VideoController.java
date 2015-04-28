/*
 * 
 * Copyright 2014 Jules White
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.magnum.dataup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.magnum.dataup.model.Video;
import org.magnum.dataup.model.VideoStatus;
import org.magnum.dataup.model.VideoStatus.VideoState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.http.Multipart;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Streaming;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedInput;

@SuppressWarnings("unused")
@Controller
public class VideoController    {

	/**
	 * You will need to create one or more Spring controllers to fulfill the
	 * requirements of the assignment. 
	 * 
	 * 
	 * ________ ________ ________ ________ ___ ___ ___ ________ ___ __ |\
	 * ____\|\ __ \|\ __ \|\ ___ \ |\ \ |\ \|\ \|\ ____\|\ \|\ \ \ \ \___|\ \
	 * \|\ \ \ \|\ \ \ \_|\ \ \ \ \ \ \ \\\ \ \ \___|\ \ \/ /|_ \ \ \ __\ \ \\\
	 * \ \ \\\ \ \ \ \\ \ \ \ \ \ \ \\\ \ \ \ \ \ ___ \ \ \ \|\ \ \ \\\ \ \ \\\
	 * \ \ \_\\ \ \ \ \____\ \ \\\ \ \ \____\ \ \\ \ \ \ \_______\ \_______\
	 * \_______\ \_______\ \ \_______\ \_______\ \_______\ \__\\ \__\
	 * \|_______|\|_______|\|_______|\|_______|
	 * \|_______|\|_______|\|_______|\|__| \|__|
	 * 
	 * Thanks a lot
	 */

	private List<Video> videos = new CopyOnWriteArrayList<Video>();
	private static final AtomicLong uniqueId = new AtomicLong(0L);
	VideoStatus vs ;
	private VideoFileManager manager;
	
	@RequestMapping(value = "/video", method = RequestMethod.GET)
	public @ResponseBody Collection<Video> getVideoList() {
		Collection<Video> c = videos ;
		return c;

	}

	@RequestMapping(value = "/video", method = RequestMethod.POST)
	public @ResponseBody Video addVideo(@RequestBody Video v) {
		/**********/
		if (v.getId() == 0) {
			v.setId(uniqueId.incrementAndGet());
		}
		
		String url_current =getDataUrl(v.getId()) ;
		v.setDataUrl(url_current);
       
		videos.add(v);

		/***************/
		return v;

	}
	
	@RequestMapping(value = "/video/{id}/data",method = RequestMethod.POST)
	public VideoStatus setVideoData(@PathVariable("id") long id, @RequestParam("data") MultipartFile videoData,HttpServletResponse response) throws IOException {
		
	    //temp.getId()==id
		//manager = VideoFileManager.get() ;
		
		for (int i=0;i<videos.size();i++) {
			if(videos.get(i).getId()!=id){
				
				
				
				response.setStatus(404);
			               }
				else{
					manager = VideoFileManager.get() ;
					
					saveSomeVideo(videos.get(i),videoData);
					response.setStatus(200);
						
						
					}
		}
			return vs ;
	}
	
	
	
	



	public void saveSomeVideo(Video v, MultipartFile videoData) throws IOException {
		
		manager.saveVideoData(v, videoData.getInputStream());
		
	}
	


	
	@RequestMapping(value = "/video/{id}/data", method = RequestMethod.GET)
	public @ResponseBody HttpServletResponse getData(@PathVariable("id") long id,HttpServletResponse response) throws IOException {
		//OutputStream os = new FileOutputStream(v.getDataUrl());
		manager = VideoFileManager.get() ;
		//manager = VideoFileManager.get() ;
		for (int i=0;i<videos.size();i++) {
	   // if(videos.get(i).getId()==id){
			if(manager.hasVideoData(videos.get(i))){
				response.setStatus(200);
				
				manager.copyVideoData(videos.get(i),response.getOutputStream());
				 
			}
			else{
			
				 response.setStatus(404);	
		     }
	    
	       }
	  /*else{
			 response.setStatus(404);
			 
	     }*/
		
		return response;
		
	}
   
         
		
         
	
	 private String getDataUrl(long videoId){
		 String url = getUrlBaseForLocalServer() + "/video/" + videoId + "/data";
         return url;
	 }

	private String getUrlBaseForLocalServer() {
		HttpServletRequest request = 
	               ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	           String base = 
	              "http://"+request.getServerName() 
	              + ((request.getServerPort() != 80) ? ":"+request.getServerPort() : "");
	           return base;
	                  }


}
