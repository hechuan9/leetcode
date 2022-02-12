class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n - 1: return False
        
        visited = set()
        
        # build_graph
        nodes = [[] for i in range(n)]
        for edge in edges:
            nodes[edge[0]].append(edge[1])
            nodes[edge[1]].append(edge[0])
            
        def dfs(node):
            if node in visited:
                return
            visited.add(node)
            for neighbor in nodes[node]:
                dfs(neighbor)
                
        dfs(0)
        return len(visited) == n
                
                