package com.orangekit.multiimageselector;

/**
 * Created by Kyle on 2015/9/15.
 */
public class ImageDescriptor {
        public String path;
        public String name;
        public long time;

        public ImageDescriptor(String path, String name, long time){
            this.path = path;
            this.name = name;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            try {
                ImageDescriptor other = (ImageDescriptor) o;
                return this.path.equalsIgnoreCase(other.path);
            }catch (ClassCastException e){
                e.printStackTrace();
            }
            return super.equals(o);
        }
}
