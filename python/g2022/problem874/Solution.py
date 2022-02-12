class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        hash_locations = set()
        for obstacle in obstacles:
            hash_locations.add((obstacle[0], obstacle[1]))
        dirs = [(0,1), (1,0), (0, -1), (-1,0)]
        curr_dir, x, y, max_distance = 0, 0, 0, 0
        for command in commands:
            if command == -2:
                curr_dir = (curr_dir -1) % 4
            elif command == -1:
                curr_dir = (curr_dir + 1) % 4
            else:
                while command and (x + dirs[curr_dir][0], y + dirs[curr_dir][1]) not in hash_locations:
                    x, y = x + dirs[curr_dir][0], y + dirs[curr_dir][1]
                    command -= 1
            #print(x, y)
            max_distance = max(max_distance, x ** 2 + y ** 2)
        return max_distance
            
                
            