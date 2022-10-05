package factory;

import Model.RuNode;

public abstract class RuNodeFactory {
public RuNode getRuNode(RuNode parent) {
	return createRuNode(parent);
}
protected abstract RuNode createRuNode(RuNode parent);
}
