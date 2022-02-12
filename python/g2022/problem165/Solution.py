class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        version1 = version1.split('.')
        version2 = version2.split('.')
        n1 = len(version1)
        n2 = len(version2)

        for i in range(min(n1, n2)):
            v1d = int(version1[i])
            v2d = int(version2[i])

            if v1d == v2d:
                continue
            elif v1d < v2d:
                return -1
            else:
                return 1

        if n1 < n2:
            for i in range(n1, n2):
                if int(version2[i]) > 0:
                    return -1
        else:
            for i in range(n2, n1):
                if int(version1[i]) > 0:
                    return 1
        return 0