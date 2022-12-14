export interface LabelValuePair<T = string> {
  label: string;
  value: T;
}

export interface CheckableTagsInputProps extends InputWithOptions {}

export interface InputWithOptions<T = string> {
  options: LabelValuePair<T>[];
  selected: T[];
  onChange: (selected: T[]) => void;
  resolver?: (option: LabelValuePair<T>) => string | T;
}

export interface AutocompleteInputProps<T = string> {
  options: LabelValuePair<T>[];
  onChange: (selected: LabelValuePair<T>) => void;
}

export interface DropdownInputProps {
  options: LabelValuePair[];
  className?: string;
  onChange?: (s: LabelValuePair) => void;
}