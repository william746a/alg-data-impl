package dev.thinke.data.structure;

import java.util.List;

public record AdjacencyList(List<EdgeNode> nodes, List<Integer> degree, Integer nVertices, Integer nEdges, Boolean directed) {
}
