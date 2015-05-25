package com.easymvc.config;

/**
 * PathNodeCreator
 * @author 唐延波
 * @date 2015-5-22
 */
public class PathNodeCreator {
	
	private final static PathNodeCreator pathNodeCreator = new PathNodeCreator();
	
	public static PathNodeCreator getInstance(){
		return pathNodeCreator;
	}

	/**
	 * getPathNode
	 * @author 唐延波
	 * @date 2015-5-22
	 * @param paths
	 * @return
	 */
	public PathNode getPathNode(String[] paths){
		PathNode parentNode = null;
		PathNode rootNode = null;
		for(int i=0;i<paths.length;i++){
			String path = paths[i];
			if(i==paths.length-1){
				PathNode node = new PathNode();
				node.setPath(path);
				parentNode.setNext(node);
			}else{
				PathNode node = new PathNode();
				node.setPath(path);
				if(parentNode!=null){
					parentNode.setNext(node);
				}else{
					rootNode = node;
				}
				parentNode = node;
			}
		}
		return rootNode;
	}
}
