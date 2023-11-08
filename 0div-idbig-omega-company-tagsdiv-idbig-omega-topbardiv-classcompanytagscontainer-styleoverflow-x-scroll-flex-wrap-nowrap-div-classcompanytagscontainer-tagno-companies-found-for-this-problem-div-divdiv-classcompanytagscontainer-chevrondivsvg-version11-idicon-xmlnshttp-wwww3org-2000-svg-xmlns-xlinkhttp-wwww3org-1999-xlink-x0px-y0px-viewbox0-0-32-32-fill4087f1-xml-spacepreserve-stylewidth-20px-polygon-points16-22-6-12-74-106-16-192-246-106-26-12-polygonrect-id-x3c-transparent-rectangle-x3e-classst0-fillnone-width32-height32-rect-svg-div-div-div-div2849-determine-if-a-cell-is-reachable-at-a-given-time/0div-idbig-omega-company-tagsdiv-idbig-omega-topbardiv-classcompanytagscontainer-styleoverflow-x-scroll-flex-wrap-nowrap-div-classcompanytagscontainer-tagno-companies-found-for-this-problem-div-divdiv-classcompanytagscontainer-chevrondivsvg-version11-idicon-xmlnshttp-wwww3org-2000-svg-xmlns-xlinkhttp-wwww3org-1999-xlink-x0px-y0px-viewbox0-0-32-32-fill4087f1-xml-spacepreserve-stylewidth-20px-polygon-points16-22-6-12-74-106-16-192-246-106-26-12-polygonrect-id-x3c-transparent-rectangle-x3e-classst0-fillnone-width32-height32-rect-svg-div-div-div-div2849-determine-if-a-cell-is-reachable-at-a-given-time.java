class Solution{ 
	public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t)  { 
		fx -= sx; 
		fy -= sy; 
		fx = Math.abs(fx); 
		fy = Math.abs(fy); 
		if(t == 1 && fx == 0 && fy == 0)
			return false; 
		return Math.max(fx, fy) <= t; 
    } 
}